package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_item_note.*
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

class NoteViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(note: Note) {
        titleTv.text = note.title
        bodyTv.text = note.title
    }

}