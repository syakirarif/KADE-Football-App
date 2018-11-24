package com.arifudesu.latihanfc.view

import com.arifudesu.latihanfc.model.Team

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}