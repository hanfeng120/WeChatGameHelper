package cn.xunger.and.wechatgamehelper;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * 悬浮窗view
 */
public class FloatingView extends FrameLayout {

  private Context context;
  private RelativeLayout rootView;
  private WindowManager.LayoutParams layoutParams;
  private FloatingManager floatingManager;
  private TextView tvInfo;
  private Button btnClick;
  private ScrollView scrollView;

  public FloatingView(Context context) {
    super(context);
    this.context = context.getApplicationContext();

    initLayoutParams();
    initView();
    initData();
  }

  private void initView() {
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    rootView = (RelativeLayout) layoutInflater.inflate(R.layout.floating_view, null);
    floatingManager = FloatingManager.getInstance(context);
    tvInfo = rootView.findViewById(R.id.tv_info);
    btnClick = rootView.findViewById(R.id.btn_click);
    scrollView = rootView.findViewById(R.id.scrollview);
    addView(rootView);
  }

  private void initData() {
    tvInfo.setText("X: " + getX() + "\nY: " + getY());
  }

  private void initLayoutParams() {
    layoutParams = new WindowManager.LayoutParams();
    layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
    layoutParams.x = 0;
    layoutParams.y = 300;
    //总是出现在应用程序窗口之上
    layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
    //设置图片格式，效果为背景透明
    layoutParams.format = PixelFormat.TRANSPARENT;
    layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
        WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
    layoutParams.width = LayoutParams.MATCH_PARENT;
    layoutParams.height = LayoutParams.WRAP_CONTENT;
  }

  public void show() {
    floatingManager.addView(this, layoutParams);
  }

  public void hide() {
    floatingManager.removeView(this);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
      Log.d("WeChat", "onTouchEvent: ");
    }
    return super.onTouchEvent(event);
  }
}
