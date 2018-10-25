package com.arifudesu.latihanfc.api

import java.net.URL

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}