package com.example.footballapplication

import android.annotation.SuppressLint
import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cl_team.*
import java.lang.reflect.Field


class TeamHolder(
    override val containerView: View,
    private val itemClick: (id: Int) -> Unit,
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var team: TeamDTO? = null

    @SuppressLint("SetTextI18n")
    fun bind(team: TeamDTO){
        this.team = team

        with(team) {
            tv_position.text = team.position.toString()
            tv_name.text = team.name
            tv_points.text = team.points.toString()

            Glide.with(containerView.context).load(team.imgUrl.toUri()).into(iv_logo)
        }
        containerView.setOnClickListener{
            itemClick(team.id)
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup, itemClick: (id: Int) -> Unit) = TeamHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cl_team, parent, false
            ), itemClick
        )
    }

    private fun getLayoutBackgroundDrawableId(resourceName: String, c: Class<*>): Int {
        try {
            val idField: Field = c.getDeclaredField(resourceName)
            return idField.getInt(idField)
        } catch (e: Exception) {
            throw RuntimeException(
                "No resource ID found for: $resourceName / $c, $e"
            )
        }
    }
}