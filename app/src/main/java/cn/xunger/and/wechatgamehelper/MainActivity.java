package cn.xunger.and.wechatgamehelper;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xunger.and.wechatgamehelper.accessibility.AccessibilityServiceUtils;
import cn.xunger.and.wechatgamehelper.constant.WeChatConstants;

public class MainActivity extends AppCompatActivity {

  private FloatingView floatingView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    floatingView = new FloatingView(this);
  }

  public void showAlertDialog(View view) {
    floatingView.show();
  }

  public void dismissAlertDialog(View view) {
    floatingView.hide();
  }

  public void openSettingPage(View view) {
    if (AccessibilityServiceUtils.isAccessibilitySettingsOn(this)) {
      openWeChatApp();
    } else {
      openSetting();
    }
  }

  private void openSetting() {
    startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
  }

  private void openWeChatApp() {
    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(WeChatConstants.WE_CHAT_PACKAGE_NAME);
  }

  /**
   * 337*1120 左起点 280*1120右起点
   */
}
