package com.example.aviatickets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aviatickets.databinding.OfferItemBinding
import com.example.aviatickets.model.entity.Flight
import com.example.aviatickets.model.entity.Offer

class OfferListAdapter : RecyclerView.Adapter<OfferListAdapter.OfferViewHolder>() {
    private var offers = mutableListOf<Offer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding = OfferItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(offers[position])
    }

    override fun getItemCount(): Int = offers.size

    fun setItems(newOffers: List<Offer>) {
        val diffResult = DiffUtil.calculateDiff(OfferDiffCallback(this.offers, newOffers))
        this.offers.clear()
        this.offers.addAll(newOffers)
        diffResult.dispatchUpdatesTo(this)
    }

    fun sortByPrice() {
        offers.sortBy { it.price }
        notifyDataSetChanged()
    }

    fun sortByDuration() {
        offers.sortBy { it.duration }
        notifyDataSetChanged()
    }

    class OfferViewHolder(private val binding: OfferItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(flight: Flight) {
            binding.departureTime.text = flight.departureTimeInfo
            binding.route.text = "${flight.departureLocation.code} - ${offer.flight.arrivalLocation.code}"
            binding.arrivalTime.text = flight.arrivalTimeInfo
            binding.duration.text = "${flight.duration} мин"
            binding.price.text = "${flight.price} ₸"
            Glide.with(airlineImage.context)
                .load(offer.flight.airline.imageUrl)
                .into(airlineImage)
        }
    }

    class OfferDiffCallback(private val oldList: List<Offer>, private val newList: List<Offer>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
