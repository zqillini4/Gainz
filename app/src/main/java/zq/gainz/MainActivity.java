package zq.gainz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

public class MainActivity extends AppCompatActivity {

    private MobileServiceClient mClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            mClient = new MobileServiceClient(
                    "https://zq-gainz.azurewebsites.net",
                    this
            );
        }
        catch (java.net.MalformedURLException ex) {
            ex.printStackTrace();
        }


        final TodoItem item = new TodoItem();
        item.Text = "Awesome item";
        mClient.getTable(TodoItem.class).insert(item, new TableOperationCallback<TodoItem>() {
            public void onCompleted(TodoItem entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    // Insert succeeded
                } else {
                    // Insert failed
                }
            }
        });

    }

    private void TestUpload() {
        int i = 1 + 1;
        int ii = 2 + 2;
        int iii = i + ii;
    }

}



