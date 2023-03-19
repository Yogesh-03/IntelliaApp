package com.example.departmentapp

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private  lateinit var iitjLogo:ImageView
    private lateinit var imageSlider:ImageSlider
    private lateinit var headImageView:ImageView
    private var storageReference = Firebase.storage.reference
    private  lateinit var headMessage: TextView
    private lateinit var headMessageShow:ImageView
    private lateinit var headMessageCardView: CardView
    private lateinit var aboutDeptCardView:CardView
    private lateinit var aboutDeptTextView:TextView
    private lateinit var aboutDeptShowImageView:ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        iitjLogo = view.findViewById(R.id.iitjLogo)
        imageSlider = view.findViewById(R.id.imageSlider)
        headMessage = view.findViewById(R.id.headMessage)
        headMessageShow = view.findViewById(R.id.headMessageShow)
        headMessageCardView = view.findViewById(R.id.headMessageCardView)
        aboutDeptCardView = view.findViewById(R.id.aboutDeptCardView)
        aboutDeptTextView = view.findViewById(R.id.aboutDeptText)
        aboutDeptShowImageView = view.findViewById(R.id.aboutDeptShowImageView)
        val imageList = ArrayList<SlideModel>()

        loadSliderImages(imageList)

        headMessage.visibility = View.GONE
        headMessageShow.setOnClickListener {
            var v:Int? = null
            if (headMessage.visibility == View.GONE){
                v = View.VISIBLE
                TransitionManager.beginDelayedTransition(headMessageCardView, AutoTransition())
                headMessageShow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
            } else {
                v = View.GONE
                headMessageShow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
            }
            headMessage.visibility = v
        }

        aboutDeptTextView.visibility = View.GONE
        aboutDeptShowImageView.setOnClickListener {
            var v:Int? = null
            if (aboutDeptTextView.visibility == View.GONE){
                v = View.VISIBLE
                TransitionManager.beginDelayedTransition(aboutDeptCardView, AutoTransition())
                aboutDeptShowImageView.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
            } else {
                v = View.GONE
                aboutDeptShowImageView.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
            }
            aboutDeptTextView.visibility = v as Int
        }
        return view
    }


    private fun loadSliderImages(imageList:ArrayList<SlideModel>) {
        //imageList.add(SlideModel("https://iitj.ac.in/department/img/materials/UG%20Pojection_MME.jpg",""))
        imageList.add(SlideModel(R.drawable.image_one))
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        storageReference.child("SliderImages/image_one.jpg").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }
        storageReference.child("SliderImages/image_two.jpg").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }
        storageReference.child("SliderImages/image_three.jpg").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }

        storageReference.child("SliderImages/image_four.png").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }
        storageReference.child("SliderImages/image_five.png").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }
        storageReference.child("SliderImages/image_six.png").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }

        storageReference.child("SliderImages/image_seven.png").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }

        storageReference.child("SliderImages/image_eight.png").downloadUrl.addOnSuccessListener {
            imageList.add(SlideModel(it.toString(), ""))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }.addOnFailureListener {
            Toast.makeText(activity,"Failure: Firebase Quota Exceeded", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}