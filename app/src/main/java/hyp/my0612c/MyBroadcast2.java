package hyp.my0612c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class MyBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i("TAG", "MyBroadcast2" + msg);
        Bundle bundle = getResultExtras(true);
        String res = bundle.getString("res");
        Log.i("TAG", "res"+res);
    }
}
