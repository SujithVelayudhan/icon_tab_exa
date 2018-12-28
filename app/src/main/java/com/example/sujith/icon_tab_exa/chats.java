package com.example.sujith.icon_tab_exa;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class chats extends Fragment {

    RecyclerView recycler_chatp;
    ArrayList<String> nameA,messageA,timeA;
    int[] img={R.drawable.doctorc,R.drawable.patient,R.drawable.lock,R.drawable.icon4,
                R.drawable.elephant,R.drawable.dot,R.drawable.phone,R.drawable.sms1};
    Verticadapt adapt;


    public chats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chats, container, false);

        recycler_chatp=v.findViewById(R.id.recycler_chat);
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

        recycler_chatp.setLayoutManager(lm);
        recycler_chatp.setAdapter(adapt);

        return v;
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
                    .inflate(R.layout.chats_layout_exp,viewGroup,false);

            return new VerticVH(vh);
        }

        @Override
        public void onBindViewHolder(@NonNull VerticVH verticVH, int i)
        {
            verticVH.chat_img.setImageResource(img[i]);
            verticVH.nam.setText(nameA.get(i));
            verticVH.mess.setText(messageA.get(i));
            verticVH.tim.setText(timeA.get(i));

        }

        @Override
        public int getItemCount() {
            return nameA.size();
        }

        class VerticVH extends RecyclerView.ViewHolder
        {
            CircleImageView chat_img;
            TextView nam,mess,tim;

            public VerticVH(@NonNull View itemView)
            {
                super(itemView);

                chat_img=itemView.findViewById(R.id.chats_image);
                nam=itemView.findViewById(R.id.chat_name);
                mess=itemView.findViewById(R.id.chat_message);
                tim=itemView.findViewById(R.id.chat_time);
            }
        }

    }
}
