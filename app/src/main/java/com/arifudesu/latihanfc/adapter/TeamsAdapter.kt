package com.arifudesu.latihanfc.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.arifudesu.latihanfc.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import com.arifudesu.latihanfc.R.id.team_badge
import com.arifudesu.latihanfc.R.id.team_name
import com.arifudesu.latihanfc.model.Team
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * </> with <3 by SyakirArif
 * say no to plagiarism
 */
class TeamsAdapter(private val teams: List<Team>, private val listener: (Team) -> Unit) :
    RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamViewHolder {
        return TeamViewHolder(
            TeamUI().createView(
                AnkoContext.create(
                    p0.context,
                    p0
                )
            )
        )
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(p0: TeamViewHolder, p1: Int) {
        p0.bindItem(teams[p1], listener)
    }

}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(team_badge)
    private val teamName: TextView = view.find(team_name)

    fun bindItem(teams: Team, listener: (Team) -> Unit) {

        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName

        itemView.onClick { listener(teams) }

    }
}

class TeamUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.team_badge
                }.lparams {
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.team_name
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }
            }
        }
    }

}