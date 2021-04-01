package com.example.footballapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cl_team.*
import kotlinx.android.synthetic.main.fragment_teams_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TeamsListFragment : Fragment(),CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job


    private lateinit var recyclerView: RecyclerView
    private lateinit var teamsList: ArrayList<TeamDTO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_teams.apply {
            layoutManager = LinearLayoutManager(context)
        }
        launch {
            val standingResponse = ApiFactory.getTeamsList()
            teamsList = ArrayList()

            standingResponse.standings[0].tableList.forEach { response ->
                teamsList.add(
                        TeamDTO(
                                response.team.id,
                                response.position,
                                response.team.name,
                                response.points,
                                response.team.crestUrl
                        )
                )
                teamsList.forEach({})
                activity?.runOnUiThread {
                    rv_teams.adapter = TeamAdapter(teamsList) {}
                    Log.d("name", response.team.name)
                }
            }
        }
    }
}
