package wia2007.example.healthier_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EarnRewardTFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EarnRewardTFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EarnRewardTFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EarnRewardTFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EarnRewardTFragment newInstance(String param1, String param2) {
        EarnRewardTFragment fragment = new EarnRewardTFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ImageButton addBtn;
    AlertDialog dialog;
    LinearLayout layout;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_earn_reward_t, container, false);

        addBtn = view.findViewById(R.id.add_activity_btn);
        layout = view.findViewById(R.id.linearContainer);

        buildDialog();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        return view;
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.dialog, null);

        EditText activityName = view.findViewById(R.id.enterActivity);

        builder.setView(view);
        builder.setTitle("Enter activity")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addCard(activityName.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        dialog = builder.create();
    }

    private void addCard(String activityName) {
        View view = getLayoutInflater().inflate(R.layout.item_view, null);

        TextView act = view.findViewById(R.id.ETACtivity);
        Button delete = view.findViewById(R.id.closeImageButton);

        act.setText(activityName);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.removeView(view);
            }
        });

        layout.addView(view);
    }
}