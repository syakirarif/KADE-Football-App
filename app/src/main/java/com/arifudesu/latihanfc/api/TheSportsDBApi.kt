package com.arifudesu.latihanfc.api

import android.net.Uri
import com.arifudesu.latihanfc.BuildConfig

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
object TheSportsDBApi {
    fun getItems(league: String?): String {
        return BuildConfig.BASE_URL + "api/vi/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getTeams(league: String?):String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("search_all_teams.php")
            .appendQueryParameter("l", league)
            .build()
            .toString()
    }
}