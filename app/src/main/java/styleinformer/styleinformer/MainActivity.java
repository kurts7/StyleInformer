package styleinformer.styleinformer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onStart()
    {
        super.onStart();

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {

                    JSONParserCustom jParse = new JSONParserCustom();
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("uid", "1"));

                    org.json.simple.JSONObject jObj = jParse.makeHttpRequest("http://styleinformer.ru/post-api/", "GET", params);

                    /*ExpandableListView listView = (ExpandableListView)findViewById(R.id.expandableListView);


                    ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();


                    for(int i=0;i<jObj.size();i++)
                    {
                        ArrayList<String> children = new ArrayList<String>();

                        children.add(jObj[i].);
                        groups.add(children);
                    }
                //Создаем адаптер и передаем context и список с данными
                ExpListAdapter adapter = new ExpListAdapter(getApplicationContext(), groups);
                listView.setAdapter(adapter);*/
            }
        });

        thread.start();
        int i = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
