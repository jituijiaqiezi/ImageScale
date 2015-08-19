package com.loveplusplus.demo.image;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends ListActivity {

    public static final String TAG = "MainActivity";
    private MyListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyTask().execute();

    }

    class MyTask extends AsyncTask<Void, Void, MyMessage> {

        @Override
        protected MyMessage doInBackground(Void... params) {
            String json = "{\"code\":200,\"msg\":\"ok\",list:["
                    + "{\"id\":110,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing.jpg\"," +
                    "\"name\":\"张三\",\"content\":\"大家好\",\"urls\":[]},"//http://b.hiphotos.baidu.com/image/pic/item/d53f8794a4c27d1e9be388e018d5ad6edcc438c8.jpg

                    + "{\"id\":111,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing2.jpg\"," +
                    "\"name\":\"李四\",\"content\":\"大家好\",\"urls\":[\"https://wdzttest.wondersgroup.com/file/pic/u_images/F8E27223-82A3-49A7-A942-105DF3DCC0A5/KJIsOXRFNH_1867005625.jpg\"]},"

                    + "{\"id\":112,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing1.jpg\"," +
                    "\"name\":\"王五\",\"content\":\"大家好\",\"urls\":[\"https://wdzttest.wondersgroup.com/file/pic/u_images/F8E27223-82A3-49A7-A942-105DF3DCC0A5/LDDLwEtdrs_1213544618.jpg\"," +
                    "\"https://wdzttest.wondersgroup.com/file/pic/u_images/F8E27223-82A3-49A7-A942-105DF3DCC0A5/fIpuJYSeGQ_1305357140.jpg\"]},"

                    + "{\"id\":113,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing6.jpg\"," +
                    "\"name\":\"赵六\",\"content\":\"大家好\",\"urls\":[\"https://wdzttest.wondersgroup.com/file/pic/u_images/F8E27223-82A3-49A7-A942-105DF3DCC0A5/LDDLwEtdrs_1213544618.jpg\"," +
                    "\"https://wdzttest.wondersgroup.com/file/pic/u_images/F8E27223-82A3-49A7-A942-105DF3DCC0A5/middle_LDDLwEtdrs_1213544618.jpg\",\"https://wdzttest.wondersgroup.com/file/pic/u_images/F8E27223-82A3-49A7-A942-105DF3DCC0A5/thumb_LDDLwEtdrs_1213544618.jpg\"]}]}";
            Gson gson = new Gson();
            MyMessage msg = gson.fromJson(json, MyMessage.class);
            return msg;
        }

        @Override
            protected void onPostExecute(MyMessage result) {
                mAdapter = new MyListAdapter(MainActivity.this, result.list);
                setListAdapter(mAdapter);

        }

    }
}
