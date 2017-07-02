package edu.gsu.httpcs.a2017summer;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.a2017summer.dialog.CustomDialog;

import static android.R.attr.button;
import static android.R.attr.onClick;
import static edu.gsu.httpcs.a2017summer.R.style.dialog;

public class DialogActivity extends BaseActivity {
    private int checkedID = 0;
    private final int DIALOG = 12345;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast("Message : " + s);

                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };

    @BindView(R.id.activity_dialog)
    RadioGroup radioGroup;

    @OnClick(R.id.activity_dialog_submit)
    public void submit(View view) {
        switch (checkedID) {
            case R.id.activity_dialog1:
                nomalDialog();
                break;
            case R.id.activity_dialog2:
                listDialog();
                break;
            case R.id.activity_dialog3:
                singleChoiceDialog();
                break;
            case R.id.activity_dialog4:
                MultiChoiceDialog();
                break;
            case R.id.activity_dialog5:
                waitingDialog();
                break;
            case R.id.activity_dialog6:
                progressDialog();
                break;
            case R.id.activity_dialog7:
                inputDialog();
                break;
            case R.id.activity_dialog8:
                CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener() {  //
                    @Override
                    public void onOkClicked(String msg) {
                        showToast(msg);
                    }

                    @Override
                    public void onCancelClicked() {

                    }
                });
                customDialog.setCanceledOnTouchOutside(true);  //when false, even if u click the outside of content, it doesn't disappear
                customDialog.show(); //
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;
                //shortToast("You chose : " + checkedId);
            }
        });
    }
    private void nomalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
                public void onClick(DialogInterface dialog, int which) {
            shortToast("You clicked Yes");
        }
        });

        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener()  {
            @Override
            public  void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Neutral");
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked cancel");
            }
        });
        builder.show();
    }
    private void listDialog() {
        final String[] items = {"item1","item2","item3","item4" };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I am a List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You Clicked: " + items[which]);
            }
        });
        builder.show();
    }

    int choice = 3;
    private void singleChoiceDialog() {
        final String[] items = {"item1","item2","item3","item4" };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a Single Choice Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: " + items[choice]);
            }
        });
        builder.show();
    }

    ArrayList<Integer> choices = new ArrayList<>();

    private void MultiChoiceDialog() {
        final String[] items = {"item1","item2","item3","item4" };
        final boolean initChoiceSets[] = {false,false, false, false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I am a multi-choice Dialog");
        builder.setMultiChoiceItems(items, initChoiceSets,  new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    choices.add(which);
                }
                else {
                    choices.remove(which);
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str = "";
                for(int i = 0; i < size; i++){
                    str += items[choices.get(i)] + " ";
                }
                shortToast("You chose : " + str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                shortToast("Cancel was clicked.");
            }
        });
        builder.show();
    }
    ProgressDialog waitingDialog;
    private void waitingDialog() {
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                shortToast("Dialog was canceled!");
            }
        });
    }
    private void progressDialog() {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
        //New Thread, Every 100ms, progress + 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("msg", "Download success");
                Message msg = Message.obtain();
                msg.what = DIALOG;
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                //shortToast("download finished"); it has error coz of not use handler and windowLeaked
                progressDialog.cancel();
            }
        }).start();
    }

    private void inputDialog() {
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
        inputDialog.setTitle("I'm an input Dialog").setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("Cancel", null).show();
    }
}
