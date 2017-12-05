package example.pullrequest.com.paulhundalproject.ui.wrapper

import android.os.Build
import android.text.Html

/**
 * Created by phundal on 12/2/17.
 */
class TextParser : ITextParser {

    override fun getParsedString(input : String) : String {
        if(input.isNotEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(input, Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                Html.fromHtml(input).toString()
            }
        }
        return input
    }
}