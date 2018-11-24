package com.arifudesu.latihanfc

import com.arifudesu.latihanfc.model.Team

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}