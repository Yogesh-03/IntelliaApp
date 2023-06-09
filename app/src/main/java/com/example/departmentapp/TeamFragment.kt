package com.example.departmentapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TeamFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeamFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<FacultyMember>
    private lateinit var myAdapter: FacultyMemberAdapter
    private lateinit var db:FirebaseFirestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_team, container, false)
        recyclerView = view.findViewById(R.id.facultyMembersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        myAdapter = FacultyMemberAdapter(newArrayList)
        recyclerView.adapter = myAdapter

        eventChangeListener()
        return view;
    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("FacultyMembers").
                addSnapshotListener(object :EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error!= null){
                            Log.e("Firestore Error", error.message.toString())
                            Toast.makeText(activity,"Firebase Quota exceeded", Toast.LENGTH_SHORT).show()
                            return
                        }

                        for (dc:DocumentChange in value?.documentChanges!!){
                            if (dc.type == DocumentChange.Type.ADDED){
                                newArrayList.add(dc.document.toObject(FacultyMember::class.java))
                            }
                        }
                        myAdapter.notifyDataSetChanged()
                    }
                })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TeamFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}