package com.arifudesu.latihanfc.main

import com.arifudesu.latihanfc.model.TeamResponse
import com.arifudesu.latihanfc.api.ApiRepository
import com.arifudesu.latihanfc.api.TheSportsDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeamList(league: String?) {
        view.showLoading()

        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(TheSportsDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}