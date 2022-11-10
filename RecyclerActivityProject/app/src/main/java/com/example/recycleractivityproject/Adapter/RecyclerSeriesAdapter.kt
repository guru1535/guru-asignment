package com.example.recycleractivityproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleractivityproject.Listner.OnMovieItemClickListner
import com.example.recycleractivityproject.Model.Webseries
import com.example.recycleractivityproject.databinding.ItemSeriesLayoutBinding

class RecyclerSeriesAdapter(var context: Context, var seriesList: MutableList<Webseries>) : RecyclerView.Adapter<RecyclerSeriesAdapter.MyViewHolder>(){

    private lateinit var binding:ItemSeriesLayoutBinding

    private lateinit var clickListner: OnMovieItemClickListner

    fun setOnSeriesItemClickedListner(clickListner: OnMovieItemClickListner){
        this.clickListner = clickListner
    }

    class MyViewHolder(var bind : ItemSeriesLayoutBinding) : RecyclerView.ViewHolder(bind.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemSeriesLayoutBinding.inflate(LayoutInflater.from(context) , parent ,false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var series = seriesList[position]


        holder.bind.tvTitle.text = series.title
        holder.bind.ivThumnail.setImageResource(series.image)


        holder.bind.cardParent.setOnClickListener {

          //  clickListner.onCradClicked(series , position)

        }

        holder.bind.ivThumnail.setOnClickListener {

          //  clickListner.onImageClicked(series , position)

        }
    }

    override fun getItemCount(): Int {
        return seriesList.size
    }
}