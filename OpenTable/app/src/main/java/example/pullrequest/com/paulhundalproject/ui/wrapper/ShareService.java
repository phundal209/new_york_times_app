package example.pullrequest.com.paulhundalproject.ui.wrapper;

import android.content.Context;
import android.content.Intent;

import example.pullrequest.com.opentable.R;

/**
 * Created by phundal on 12/4/17.
 */

public class ShareService implements IShareServiceWrapper {
    private Context context;
    private String SUBJECT;


    public ShareService(Context context) {
        this.context = context;
        this.SUBJECT = context.getString(R.string.email_subject);
    }

    @Override
    public void shareWithEmail(String emailBody) {
        if(emailBody == null || emailBody.isEmpty()) {
            return;
        }
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
        context.startActivity(Intent.createChooser(emailIntent, "Send email.."));
    }
}
