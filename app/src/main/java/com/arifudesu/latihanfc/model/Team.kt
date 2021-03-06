package com.arifudesu.latihanfc.model

import com.google.gson.annotations.SerializedName

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
data class Team(
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)