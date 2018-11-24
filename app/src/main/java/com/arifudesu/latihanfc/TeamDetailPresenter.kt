package com.arifudesu.latihanfc

import com.arifudesu.latihanfc.api.ApiRepository
import com.arifudesu.latihanfc.api.TheSportsDBApi
import com.arifudesu.latihanfc.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeamDetail(teamId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportsDBApi.getTeamDetail(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}