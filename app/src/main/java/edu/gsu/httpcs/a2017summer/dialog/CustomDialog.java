package edu.gsu.httpcs.a2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.a2017summer.R;

/**
 * Created by supark on 6/21/17.
 */

public class CustomDialog extends Dialog {

    private final ICustomDialogListener listener;

    public interface ICustomDialogListener {
        public void onOkClicked(String msg);  //interface only define abstract method(this line)
        abstract void onCancelClicked();
    }

    @OnClick(R.id.dialog_custom_ok)
    public void ok (View view) {
        listener.onOkClicked("You clicked OK");  //because customDialog is not activity,
        // it needs listener to go back to activity, but listener should create by interface
        cancel();  //it doesn't close
    }

    public CustomDialog(@NonNull Context context, ICustomDialogListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
        this.listener = listener;
    }
}
