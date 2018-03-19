package com.cognizance.cognizance18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cognizance.cognizance18.adapters.EventsRViewAdapter;
import com.cognizance.cognizance18.database.EventPreview;
import com.cognizance.cognizance18.models.Event;
import com.cognizance.cognizance18.models.EventDetails.EventD;
import com.cognizance.cognizance18.models.EventDetails.EventDescription;
import com.cognizance.cognizance18.models.Example;
import com.cognizance.cognizance18.utilities.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashank on 12/1/18.
 */

public class EventDetails extends AppCompatActivity{

    private RelativeLayout intro,registration,rules,problem,contact,Registerbtn;

    private TextView introText,registrationText,rulesText,problemText,contactText;
    private Button btn ;

    private int PRIVATE_MODE = 0;

    String procedure;
    String rule;
    String description1;




    private List<EventD> customList;











    private static final String PREF_NAME = "LoginPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_fragment);
        initializeViews();
        customList = new ArrayList<EventD>();


        dataSet();
//        eventId = getIntent().getIntExtra("id",0);
//        procedure = getIntent().getStringExtra("procedure");
//        rule=getIntent().getStringExtra("rules");
//        description1=getIntent().getStringExtra("description");

       getEventDetails();

    }


    private void getEventDetails(){

        SharedPreferences pref = getBaseContext().getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        int id=pref.getInt("id",0);
        int a=id -1;
        String str = Integer.toString(a);
        expandCardview(a);



    }

    private void expandCardview(int pos){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cognizance.org.in/enroll#signup"));
                startActivity(i);
            }
        });


        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (introText.getVisibility()==View.GONE){
                    introText.setVisibility(View.VISIBLE);
                    introText.setText(customList.get(pos).getInfo());
                }
                else {
                    introText.setVisibility(View.GONE);
                }
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (registrationText.getVisibility()==View.GONE){
                    registrationText.setVisibility(View.VISIBLE);
                    registrationText.setText(customList.get(pos).getProcedure());
                }
                else {
                    registrationText.setVisibility(View.GONE);
                }


            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rulesText.getVisibility()==View.GONE){
                    rulesText.setVisibility(View.VISIBLE);
                    rulesText.setText(customList.get(pos).getRules() );
                }
                else {
                    rulesText.setVisibility(View.GONE);
                }
            }
        });

        problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (problemText.getVisibility()==View.GONE){
                    problemText.setVisibility(View.VISIBLE);
                }
                else {
                    problemText.setVisibility(View.GONE);
                }
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contactText.getVisibility()==View.GONE){
                    contactText.setVisibility(View.VISIBLE);
                }
                else {
                    contactText.setVisibility(View.GONE);
                }
            }
        });
    }

    private void dataSet(){

        EventD event=new EventD(1,"We live in a world where humanity has found solace in relying entirely upon technology. A.I. has become a primary component of next generation&#39;s technology. Every country is trying to embody and enhance its reach in the field of A.I. This event will try answering the big question- Whether or not we can trust it.","Go to your Dashboard and find the event under Centrestage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master&rsquo;s Degree in any discipline.</li>\\n\\t<li>Team Size: Maximum size up to 3 members.</li>\\n\\t<li>No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.</li>\\n\\t<li>Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.</li>\\n\\t<li>Multistage Rules: The event is comprised of 3 stages.");
        customList.add(event);

        EventD event1= new EventD(2,"e all might have laughed when in an episode of Friends, Joey boasts about his &quot;huge stack of porn&quot; being a testament to his masculinity. But pornography is not just an assertion of masculinity, or something that can be dismissed under the garb of &quot;boys will be boys&quot;. An obsession with pornography can have far reaching effects on physical health and emotional well-being, not to mention the time and money that&#39;s invested into the habit. Porn addicts have complained of exhaustion, numbness and about the mind being in overdrive.&nbsp","Go to your <strong>Dashboard</strong> and find the event under <strong>Centrestage Events</strong>, then Register for it.","Eligibility: Student pursuing Undergraduate/Master&rsquo;s Degree in any discipline.</li>\\n\\t<li>Team Size: Maximum size up to 3 members.</li>\\n\\t<li>No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.</li>\\n\\t<li>Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.</li>\\n\\t<li>Multistage Rules: The event is comprised of 3 stages");
        customList.add(event1);
        EventD event2=new EventD(3,"Delhi's air has now become a toxic blanket that wraps over the city and not only harms its residents but coupling with weather phenomenon like fog, it has shown its deadly repercussions by many incidents including reduced visibility, respiratory complications and many more. The city which is already toiling due to air pollution has to bear the atrocities of winter as well. Both of them combining together to give rise to a sleeping demon ‘Smog’."
                ,"Go to your Dashboard and find the event under Centrestage Events, then Register for it.",
                "Team Size: Maximum size up to 3 members."+
                "No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.\n" +
                "Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.\n" +
                "Multistage Rules: The event is comprised of 3 stages."
                );
        customList.add(event2);
        EventD event3 =new EventD(4,"With the aim being to technovise education, this event invites you to come up with ideas to do away with the loopholes in the education system by the introduction of technology, i.e, to truly technovise teaching.","Go to your Dashboard and find the event under Centrestage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline." +
                "Team Size: Maximum size up to 3 members." +
                "No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.\n" +
                "Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.\n" +
                "Multistage Rules: The event is comprised of 3 stages."
                );
        customList.add(event3);
        EventD event4 =new EventD(5,"Instant messaging apps such as WhatsApp and Hike have given rise to a new vocabulary (commonly known as SMS lingo) consisting of short and concise words. These concise words are efficient enough to convey the message in a lesser number of characters. Further, we practice our own conventions with our friends and have thus mastered the art of shorthand. This event tests your understanding with your friend. The aim of this game is to write given statements using least number of characters that your friend understands. Bring out the creativity and analytical skills in you to prove the strength of your efficiency with your friend.","Go to your Dashboard and find the event under Centrestage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline." +
                "Team Size: Maximum size up to 3 members." +
                "No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.\n" +
                "Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.\n" +
                "Multistage Rules: The event is comprised of 3 stages."
        );
        customList.add(event4);






    }
//
//    private void setViews(){
//
//        ArrayList<EventPreview> eventsList;
//        eventsList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            EventPreview event = new EventPreview();
//            event.setName("Event" + (i + 1));
//            eventsList.add(event);
//        }
//
//        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
//                , LinearLayoutManager.HORIZONTAL, false));
//
//    }

    private void initializeViews(){
        intro = (RelativeLayout)findViewById(R.id.introLayout);
        registration = (RelativeLayout)findViewById(R.id.registration);
        rules = (RelativeLayout)findViewById(R.id.rules);
        problem = (RelativeLayout)findViewById(R.id.problem);
        contact = (RelativeLayout)findViewById(R.id.contact);

        introText =(TextView)findViewById(R.id.info);
        registrationText = (TextView)findViewById(R.id.registrationProcedure);
        rulesText =(TextView)findViewById(R.id.rulesAndRegulation);
        problemText=(TextView)findViewById(R.id.problemStatment);
        contactText=(TextView)findViewById(R.id.contactDetails);
    }

}
