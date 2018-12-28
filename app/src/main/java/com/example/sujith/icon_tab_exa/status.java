package com.example.sujith.icon_tab_exa;


import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class status extends Fragment {
    RecyclerView recycler_statusp;
    ArrayList<String> nameA,messageA,timeA;
    int[] img={R.drawable.doctorc,R.drawable.patient,R.drawable.lock,R.drawable.icon4,
            R.drawable.elephant,R.drawable.dot,R.drawable.phone,R.drawable.sms1};
    Verticadapt adapt;

    VideoView s_video;


    public status() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vs= inflater.inflate(R.layout.fragment_status, container, false);

        recycler_statusp=vs.findViewById(R.id.recycler_status);
        nameA=new ArrayList<>();
        nameA.add("Doctor");
        nameA.add("Patient");
        nameA.add("Lock");
        nameA.add("Icon4");
        nameA.add("Elephant");
        nameA.add("Dot");
        nameA.add("Phone");
        nameA.add("SMS");

        messageA=new ArrayList<>();
        messageA.add("doctor");
        messageA.add("patient");
        messageA.add("locked");
        messageA.add("icon");
        messageA.add("doctor");
        messageA.add("patient");
        messageA.add("locked");
        messageA.add("icon");

        timeA=new ArrayList<>();
        timeA.add("today");
        timeA.add("today");
        timeA.add("today");
        timeA.add("today");
        timeA.add("today");
        timeA.add("today");
        timeA.add("today");
        timeA.add("today");


        adapt=new Verticadapt(nameA);

        LinearLayoutManager lm=new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);

        recycler_statusp.setLayoutManager(lm);
        recycler_statusp.setAdapter(adapt);

        return vs;
    }

    private class Verticadapt extends RecyclerView.Adapter<Verticadapt.VerticVH>
    {
        List<String> li;

        Verticadapt(List<String> li)
        {
            this.li=nameA;
        }

        @NonNull
        @Override
        public VerticVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
            View vh=LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.status_layout_exp,viewGroup,false);

            return new VerticVH(vh);
        }

        @Override
        public void onBindViewHolder(@NonNull final VerticVH verticVH, final int i)
        {
            verticVH.chat_img.setImageResource(img[i]);
            verticVH.nam.setText(nameA.get(i));
            verticVH.mess.setText(messageA.get(i));
            verticVH.tim.setText(timeA.get(i));

            verticVH.lin_layp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {


                        LayoutInflater l=LayoutInflater.from(getContext());
                        View vv=l.inflate(R.layout.status_cust_alert_zero,null);
                        s_video=(VideoView)vv.findViewById(R.id.s_videoView);

                        AlertDialog.Builder AB=new AlertDialog.Builder(getContext());
                        AB.setView(vv);

                        AlertDialog A=AB.create();
                        A.show();

                    if (i==0)
                    {

                        String video_path = "android.resource://com.example.sujith.icon_tab_exa/"
                                + R.raw.song;
                        s_video.setVideoURI(Uri.parse(video_path));
                        s_video.start();



                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return nameA.size();
        }

        class VerticVH extends RecyclerView.ViewHolder
        {
            CircleImageView chat_img;
            TextView nam,mess,tim;
            LinearLayout lin_layp;

            public VerticVH(@NonNull View itemView)
            {
                super(itemView);

                chat_img=itemView.findViewById(R.id.status_image);
                nam=itemView.findViewById(R.id.status_name);
                mess=itemView.findViewById(R.id.status_message);
                tim=itemView.findViewById(R.id.status_time);
                lin_layp=itemView.findViewById(R.id.lin_layout);

            }
        }

    }

}
