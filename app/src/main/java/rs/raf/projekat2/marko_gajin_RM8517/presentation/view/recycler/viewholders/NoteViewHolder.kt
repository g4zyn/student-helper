package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_item_note.*
import kotlinx.android.synthetic.main.layout_item_note.view.*
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

class NoteViewHolder(
    override val containerView: View,
    private val onDeleteBtnClicked: (Int) -> Unit,
    private val onEditBtnClicked: (Int) -> Unit,
    private val onArchiveBtnClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        initListeners()
    }

    private fun initListeners() {
        containerView.deleteBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onDeleteBtnClicked.invoke(adapterPosition)
            }
        }
        containerView.editBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onEditBtnClicked.invoke(adapterPosition)
            }
        }
        containerView.archiveBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onArchiveBtnClicked.invoke(adapterPosition)
            }
        }
    }

    fun bind(note: Note) {
        titleTv.text = note.title
        bodyTv.text = note.body
    }

}