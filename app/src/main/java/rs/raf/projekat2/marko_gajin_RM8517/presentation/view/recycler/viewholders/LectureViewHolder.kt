package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.viewholders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_item_lecture.*
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture

class LectureViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    @SuppressLint("SetTextI18n")
    fun bind(lecture: Lecture) {
//        titleTv.text = """${lecture.name} - ${lecture.type}"""
        titleTv.text = "${lecture.name} - ${lecture.type}"
        professorTv.text = lecture.professor
        classroomTv.text = lecture.classroom
        groupsTv.text = lecture.groups
        dayTv.text = lecture.day
        timeTv.text = lecture.time
    }

}