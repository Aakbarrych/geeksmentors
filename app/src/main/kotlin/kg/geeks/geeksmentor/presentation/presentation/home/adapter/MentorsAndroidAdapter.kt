package kg.geeks.geeksmentor.presentation.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kg.geeks.geeksmentor.data.model.Mentors
import kg.geeks.geeksmentor.databinding.List3ItemBinding

class MentorsAndroidAdapter(private val mentorList: List<Mentors>) : RecyclerView.Adapter<MentorsAndroidAdapter.MentorsAndroidViewHolder>(){

    inner class MentorsAndroidViewHolder(binding: List3ItemBinding) : RecyclerView.ViewHolder(binding.root){
        val mentorsImageView : ImageView = binding.rv3Img
        val mentorsNames : TextView = binding.rv3Name
        val mentorsStudentNumber : TextView = binding.rv3PersonNum
        val mentorsLikes : TextView = binding.rv3LikeNum
        val mentorsDislikes : TextView = binding.rv3DislikeNum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorsAndroidViewHolder {
        return MentorsAndroidViewHolder(List3ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MentorsAndroidViewHolder, position: Int) {
        val mentors = mentorList[position]
        holder.mentorsImageView.setImageResource(mentors.image)
        holder.mentorsNames.text = mentors.name
        holder.mentorsStudentNumber.text = mentors.studentNumber.toString()
        holder.mentorsLikes.text = mentors.likes.toString()
        holder.mentorsDislikes.text = mentors.dislikes.toString()
    }

    override fun getItemCount(): Int {
        return mentorList.size
    }
}