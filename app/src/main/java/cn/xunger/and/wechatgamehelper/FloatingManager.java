package cn.xunger.and.wechatgamehelper;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/**
 * 悬浮窗管理类
 */
public class FloatingManager {

  private static FloatingManager floatingManager;
  private WindowManager windowManager;
  private Context context;

  public static FloatingManager getInstance(Context context) {
    if (floatingManager == null) {
      floatingManager = new FloatingManager(context);
    }
    return floatingManager;
  }

  private FloatingManager(Context context) {
    this.context = context;
    windowManager = (WindowManager) this.context.getSystemService(Context.WINDOW_SERVICE);//获得WindowManager对象
  }

  /**
   * 添加悬浮窗
   *
   * @param view
   * @param params
   * @return
   */
  protected boolean addView(View view, WindowManager.LayoutParams params) {
    try {
      windowManager.addView(view, params);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 移除悬浮窗
   *
   * @param view
   * @return
   */
  protected boolean removeView(View view) {
    try {
      windowManager.removeView(view);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 更新悬浮窗参数
   *
   * @param view
   * @param params
   * @return
   */
  protected boolean updateView(View view, WindowManager.LayoutParams params) {
    try {
      windowManager.updateViewLayout(view, params);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public WindowManager getWindowManager() {
    return windowManager;
  }
}
