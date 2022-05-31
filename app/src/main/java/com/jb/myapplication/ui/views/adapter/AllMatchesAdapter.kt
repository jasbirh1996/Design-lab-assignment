package com.jb.myapplication.ui.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jb.myapplication.R
import com.jb.myapplication.data.network.model.DefineLabsResponse

class AllMatchesAdapter (var context : Context, var mList : List<DefineLabsResponse.Response.Venue>,var listner : onSelect) : RecyclerView.Adapter<AllMatchesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_all_matches,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = mList.get(position)
        val matchId = "id: "+ data.id
        val userName = "name: "+ data.name
        val userAdd = "address: " + data.location.address
        val userState = "state: "+ data.location.state



    holder.apply {
        if(data.isSelected == 1){
            inActiveStar.visibility = View.GONE
            activeStar.visibility = View.VISIBLE
        }else{

            activeStar.visibility = View.GONE
            inActiveStar.visibility = View.VISIBLE
        }
        id.setText(matchId)
        name.setText(userName)
        address.text = userAdd
        state.text = userState


        inActiveStar.setOnClickListener {
            inActiveStar.visibility = View.GONE
            activeStar.visibility = View.VISIBLE
            listner.onEnable(1,data.id)
        }
        activeStar.setOnClickListener {
            activeStar.visibility = View.GONE
            inActiveStar.visibility = View.VISIBLE
            listner.onDisable(0,data.id)

        }
    }

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var id : TextView
        lateinit var name : TextView
        lateinit var address : TextView
        lateinit var state : TextView
        lateinit var activeStar : ImageView
        lateinit var inActiveStar : ImageView


        init {
            id = itemView.findViewById(R.id.matchId)
            name = itemView.findViewById(R.id.name)
            address = itemView.findViewById(R.id.address)
            state = itemView.findViewById(R.id.state)
            inActiveStar = itemView.findViewById(R.id.inActiveStar)
            activeStar = itemView.findViewById(R.id.activeStar)

        }

    }
    interface onSelect{
        fun onEnable(value : Int,id:String)
        fun onDisable(value : Int,id:String)
    }

}