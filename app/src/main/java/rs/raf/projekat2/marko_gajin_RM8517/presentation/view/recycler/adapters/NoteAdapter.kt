package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.diff.NoteDiffCallback
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.viewholders.NoteViewHolder

class NoteAdapter(
    private val onDeleteBtnClicked: (Note) -> Unit,
    private val onEditBtnClicked: (Note) -> Unit,
    private val onArchiveBtnClicked: (Note) -> Unit
) : ListAdapter<Note, NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_item_note, parent, false)

        return NoteViewHolder(
            view,
            { onDeleteBtnClicked.invoke(getItem(it)) },
            { onEditBtnClicked.invoke(getItem(it)) },
            { onArchiveBtnClicked.invoke(getItem(it)) }
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}