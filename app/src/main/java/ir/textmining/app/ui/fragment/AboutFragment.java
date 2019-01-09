package ir.textmining.app.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.textmining.app.R;

public class AboutFragment extends DialogFragment {
  @BindView(R.id.title)
  AppCompatTextView title;
  @BindView(R.id.version_app_text_view)
  AppCompatTextView versionAppTextView;
  private Activity activity;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_about,
        container, false);
    ButterKnife.bind(this, view);
    activity = getActivity();
    setAppVersion();
    return view;
  }

  private void setAppVersion() {
    String versionName = "";
    try {
      versionName = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    }
    versionAppTextView.setText(versionName);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Dialog dialog = super.onCreateDialog(savedInstanceState);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setCancelable(true);
    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
    lp.copyFrom(dialog.getWindow().getAttributes());
    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
    lp.height = WindowManager.LayoutParams.MATCH_PARENT;
    dialog.getWindow().setAttributes(lp);
    return dialog;
  }

  @OnClick(R.id.close_button)
  void close() {
    dismiss();
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStack();
    }
  }

  @OnClick({R.id.source_code_layout, R.id.website_layout, R.id.developer_layout})
  void handleLayoutClick(View view) {
    switch (view.getId()) {
      case R.id.source_code_layout:
        break;
      case R.id.website_layout:
        break;
      case R.id.developer_layout:
        break;
    }
  }
}
