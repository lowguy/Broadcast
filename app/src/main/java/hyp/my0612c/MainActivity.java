package hyp.my0612c;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 组件篇 - BroadcastReceiver
 * 1、Broadcast
 * 2、BroadcastReceiver
 * 一 使用方法
 *      发送    【封装在Intent  调用】
 *      接受    【注册后的 如果匹配则接收】
 *      ！！！！！！！！！！！！！！！！！
 *      生命周期很短 不宜做较耗时的操作 应该通过Intent给Service，由Service来完成 不能使用线程
 *      ！！！！！！！！！！！！！！！！！
 * 【Normal broadcasts 普通广播】 由Context.sendBroadcast来发起；他是完全异步的操作；所有这条广播的接收者都是无序的，通常情况下是同时接收到的；同时这也意味着我们不能使用它的结果或者终止这条广播。
 *  特点 同级别随机无序；不同级别由高到低；接收者不能终止广播也不能处理广播；同级别动态注册高于静态注册
 * 【Ordered broadcasts 无序广播】 由Context.sendOrderedBroadcast来发起；在同一时刻他只会发送给同一个接收者；接收者依次执行，同时他可以把结果传递给下一个接收者，当然他也可以终止本次广播的执行。
 *  特点 同级别接收顺序是无序的；可以终止并处理广播；同级别动态注册高于静态注册
 */
public class MainActivity extends AppCompatActivity {
    private static final String MACTION = "com.890vip.action";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态注册
//        IntentFilter intentFilter = new IntentFilter(ACTION);
//        MyBroadcast2 bc2 = new MyBroadcast2();
//        registerReceiver(bc2,intentFilter);
    }
    public void doClick(View view){
        switch (view.getId()){
            case R.id.button:{
                Intent intent = new Intent();
                intent.putExtra("msg","890vip来喽1");
                intent.setAction(MACTION);
                sendBroadcast(intent);
                break;
            }
            case R.id.button2:{
                Intent intent = new Intent();
                intent.putExtra("msg","890vip来喽2");
                intent.setAction(MACTION);
                sendOrderedBroadcast(intent,null);
                break;
            }
            case R.id.button3:{
                Intent intent = new Intent();
                intent.putExtra("msg","890vip来喽3");
                intent.setAction("com.890vip.action3");
                sendStickyBroadcast(intent);
                IntentFilter intentFilter = new IntentFilter("com.890vip.action3");
                MyBroadcast3 bc3 = new MyBroadcast3();
                registerReceiver(bc3,intentFilter);
                break;
            }
            default:{
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //必须的
//        unregisterReceiver();
    }
}
