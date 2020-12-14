package com.droid.notebook.utils.regexUtil

import com.droid.notebook.utils.constants.Constants

class RegexUtil {

    fun isTextContainsHttp(text: String): Boolean {
        var regex = Constants.urlFormat.toRegex()
        return regex.containsMatchIn(text)
    }
}