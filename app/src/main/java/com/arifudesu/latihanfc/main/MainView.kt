package com.arifudesu.latihanfc.main

import com.arifudesu.latihanfc.model.Team

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}