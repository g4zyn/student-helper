package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.diff.LectureDiffCallback
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.viewholders.LectureViewHolder

class ScheduleAdapter : ListAdapter<Lecture, LectureViewHolder>(LectureDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_item_lecture, parent, false)

        return LectureViewHolder(view)
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}