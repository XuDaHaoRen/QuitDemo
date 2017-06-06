package my.xbl.com.fristdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //点击返回按钮，实现点击两次退出的效果
    //上一次点击的时间
    long last = -1;
    @Override
    public void onBackPressed() {
        //将父类方法点击一次就销毁界面的方法注释掉
        //super.onBackPressed();
        //获取当前点击的时间
        long now = System.currentTimeMillis();
        //第一次点击返回键则last=-1
        if (last == -1) {
            Toast.makeText(MainActivity.this, "请再点击一次退出界面", Toast.LENGTH_SHORT).show();
            //第一次的点击事件则就变成了上一次的点击时间
            last = now;
            //如果不是第一次点击
        } else {
            //判断两次点击的时间间隔
            //时间间隔正确
            if ((now - last) < 2000) {
                Toast.makeText(MainActivity.this, "已退出", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                //如果时间间隔太长则第二次点击当做第一次处理
                last = now;
                Toast.makeText(MainActivity.this, "请再点击一次退出界面", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
