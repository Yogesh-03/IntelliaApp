package com.example.departmentapp

import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {
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

    private  lateinit var callNow:TextView
    private lateinit var emailNow:TextView
    private lateinit var openMap:TextView
    private lateinit var facebook:ImageView
    private lateinit var twitter:ImageView
    private lateinit var yt:ImageView
    private lateinit var insta:ImageView
    private lateinit var imageSliderContact:ImageSlider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_contact, container, false)
        callNow = view.findViewById(R.id.callNow)
        emailNow = view.findViewById(R.id.emailNow)
        openMap = view.findViewById(R.id.openMap)
        facebook = view.findViewById(R.id.facebook)
        twitter = view.findViewById(R.id.twitter)
        yt = view.findViewById(R.id.youtube)
        insta = view.findViewById(R.id.insta)
        imageSliderContact = view.findViewById(R.id.imageSliderContact)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://img.freepik.com/free-photo/hot-line-contact-us-call-center-search-interface_53876-124009.jpg",""))
        imageList.add(SlideModel("https://images.collegedunia.com/public/image/01c304ee7f115d0babf1affbc849009b.png?tr=w-651,h-325,c-force",""))
        imageSliderContact.setImageList(imageList, ScaleTypes.FIT)
        facebook.setOnClickListener {
            goToUrl("https://www.facebook.com/IITJOfficial/")
        }

        twitter.setOnClickListener {
            goToUrl("https://twitter.com/iitjodhpur")
        }

        yt.setOnClickListener {
            goToUrl("https://www.youtube.com/channel/UCFfCylvEDIB1IH4GaRVRyLA")
        }

        insta.setOnClickListener {
            goToUrl("https://www.instagram.com/insta_iitj2019/")
        }

        callNow.setOnClickListener {
            val intent:Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "02912801553"))
            startActivity(intent)
        }

        emailNow.setOnClickListener {
            val intent:Intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, "mme@iitj.ac.in")
            startActivity(intent)
        }

        openMap.setOnClickListener {
            val intent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo: 26.47113 73.11342"))
            startActivity(intent)
        }
        return view
    }

    private fun goToUrl(s: String) {
        val uri:Uri = Uri.parse(s)
        val intent:Intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}