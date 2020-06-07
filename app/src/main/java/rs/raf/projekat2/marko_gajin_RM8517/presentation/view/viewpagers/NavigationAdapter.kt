package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.viewpagers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments.NotesFragment
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments.ProfileFragment
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments.ScheduleFragment
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments.StatsFragment

class NavigationAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 4
        const val FRAGMENT_SCHEDULE = 0
        const val FRAGMENT_NOTES = 1
        const val FRAGMENT_PROFILE = 2
        const val FRAGMENT_STATS = 3
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            FRAGMENT_SCHEDULE -> ScheduleFragment()
            FRAGMENT_NOTES -> NotesFragment()
            FRAGMENT_STATS -> StatsFragment()
            else -> ProfileFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            FRAGMENT_SCHEDULE -> "schedule"
            FRAGMENT_NOTES -> "notes"
            FRAGMENT_STATS -> "stats"
            else -> "profile"
        }
    }
}