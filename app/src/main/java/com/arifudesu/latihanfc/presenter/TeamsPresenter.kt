package com.arifudesu.latihanfc.presenter

import com.arifudesu.latihanfc.model.TeamResponse
import com.arifudesu.latihanfc.api.ApiRepository
import com.arifudesu.latihanfc.api.TheSportsDBApi
import com.arifudesu.latihanfc.view.TeamsView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
class TeamsPresenter(
    private val view: TeamsView,
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