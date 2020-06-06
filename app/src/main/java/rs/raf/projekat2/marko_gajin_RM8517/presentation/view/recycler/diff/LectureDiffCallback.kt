package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture

class LectureDiffCallback : DiffUtil.ItemCallback<Lecture>() {

    override fun areItemsTheSame(oldItem: Lecture, newItem: Lecture): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Lecture, newItem: Lecture): Boolean {
        return oldItem.name == newItem.name
                && oldItem.type == newItem.type
                && oldItem.professor == newItem.professor
                && oldItem.day == newItem.day
                && oldItem.time == newItem.time
                && oldItem.groups == newItem.groups
                && oldItem.classroom == newItem.classroom
    }
}