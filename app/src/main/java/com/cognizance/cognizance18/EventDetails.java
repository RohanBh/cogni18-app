package com.cognizance.cognizance18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Measure;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.facebook.all.All;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashank on 12/1/18.
 */

public class EventDetails extends AppCompatActivity{

    private RelativeLayout intro,registration,rules,problem,contact;

    private TextView introText,registrationText,rulesText,problemText,contactText,event;
    private Button btn ;

    private ImageView imageView;


    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LoginPref";

    String procedure;
    String rule;
    String description1;

    private EventDescription description;


    private List<EventD> customList;












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_fragment);
        initializeViews();
        customList = new ArrayList<EventD>();



//        eventId = getIntent().getIntExtra("id",0);
//        procedure = getIntent().getStringExtra("procedure");
//        rule=getIntent().getStringExtra("rules");
//        description1=getIntent().getStringExtra("description");

        dataSet();
       getEventDetails();

    }


    private void getEventDetails(){

        SharedPreferences pref = getBaseContext().getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        int id=pref.getInt("id",0);
        String name = pref.getString("name","");
        event.setText(name);
        int a=id -1;
        String str = Integer.toString(a);
        expandCardview(a);

        Call<EventDescription> call = ApiUtils.getInterfaceService().getEventDetails(id);
        call.enqueue(new Callback<EventDescription>() {
            @Override
            public void onResponse(Call<EventDescription> call, Response<EventDescription> response) {
                if (response.isSuccessful()){
                    description=response.body();

                    String thumbnail = description.getEvent().getThumbnail();
                    Picasso.with(getBaseContext()).load(thumbnail).placeholder(R.drawable.button_background)
                            .into(imageView);




                }
            }

            @Override
            public void onFailure(Call<EventDescription> call, Throwable t) {

            }
        });



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

        EventD event1= new EventD(2,"We all might have laughed when in an episode of Friends, Joey boasts about his &quot;huge stack of porn&quot; being a testament to his masculinity. But pornography is not just an assertion of masculinity, or something that can be dismissed under the garb of &quot;boys will be boys&quot;. An obsession with pornography can have far reaching effects on physical health and emotional well-being, not to mention the time and money that&#39;s invested into the habit. Porn addicts have complained of exhaustion, numbness and about the mind being in overdrive.&nbsp","Go to your <strong>Dashboard</strong> and find the event under <strong>Centrestage Events</strong>, then Register for it.","Eligibility: Student pursuing Undergraduate/Master&rsquo;s Degree in any discipline.</li>\\n\\t<li>Team Size: Maximum size up to 3 members.</li>\\n\\t<li>No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.</li>\\n\\t<li>Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.</li>\\n\\t<li>Multistage Rules: The event is comprised of 3 stages");
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

        EventD event4 =new EventD(5,"","","");
        customList.add(event4);


        EventD event5 =new EventD(6,"Instant messaging apps such as WhatsApp and Hike have given rise to a new vocabulary (commonly known as SMS lingo) consisting of short and concise words. These concise words are efficient enough to convey the message in a lesser number of characters. Further, we practice our own conventions with our friends and have thus mastered the art of shorthand. This event tests your understanding with your friend. The aim of this game is to write given statements using least number of characters that your friend understands. Bring out the creativity and analytical skills in you to prove the strength of your efficiency with your friend.","Go to your Dashboard and find the event under Centrestage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline." +
                "Team Size: Maximum size up to 3 members." +
                "No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.\n" +
                "Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.\n" +
                "Multistage Rules: The event is comprised of 3 stages.");
        customList.add(event5);


        EventD event6 =new EventD(7,"We may be at the dawn of a new revolution. This revolution started with a new fringe economy on the Internet, an alternative currency called Bitcoin that was issued and backed not by a central authority, but by automated consensus among networked users. Solving real life problems related to a particular sector be it healthcare, finance or any other sector using Blockchain, is the aim of this event."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 3 members.\n" +
                "No Double Troubles: Only one entry would be acceptable. In case of multiple entries, by default, the first one would be taken for granted.\n" +
                "Zero Plagiarism: The documents would be tested via special software for plagiarism. If some duplication would be found, the entire work would be rejected from the competition.\n" +
                "Multistage Rules: The event is comprised of 3 stages.\n");
        customList.add(event6);


        EventD event7 =new EventD(8,"LASERS have always been amusing. Since our childhood, playing with LASERs has been exciting. It’s time to rekindle the play and this time, play to win. To win, aim to target the bull’s eye by reflecting your LASER beam on multiple mirrors."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","It is an on the spot fun event.\n" +
                "Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 3 members.\n"+"Go to your Dashboard and find the event under Centerstage Events, then Register for it.");
        customList.add(event7);


        EventD event8 =new EventD(9,"All men are afraid in battle. Live daringly, boldly, fearlessly. Taste the relish to be found in a battle - in having put forth the best within you. The time to take counsel of your fears is before you make an important decision. That's the time to listen to every fear you can imagine! When you have collected all the facts and fears and made your decision, turn off all your fears and go ahead!\n" +
                "Welcome to POWERDRIFT ‘18: Where Attitude is a little thing that makes a big difference!","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event8);

        EventD event9 =new EventD(10,"This workshop aims at encouraging young minds to have a wide area of vision in the field of cyber security\n" +
                "and computer forensic by motivating and encouraging our highly talented youth to actively participate in the\n" +
                "various National and International Level Technical Symposiums, Competitions, Trainings and fulfill various\n" +
                "industrial needs in the field of Cyber and Information Security.\n" +
                "Exposure and apt knowledge is a must to be a pioneer in this field. Hence, as an effort to accomplish this aim,\n" +
                "Pristine team will cover all aspects of Ethical Hacking and Information Security needed to be an expert in the\n" +
                "field of Information Security thereby bridging the gap between students and the market demands."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event9);

        EventD event10 =new EventD(11,"Poseidon (can be viewed as “Ship Wreck”) is a robotic race type shipping event where the participants have to complete laps on the track in the minimum possible time opting tricky shortcuts crossing many obstructions which resemble inferno in reality.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event10);

        EventD event11 =new EventD(12,"Ethical hacking is all about employing the white hat hacker skills to prevent the black hat hackers from doing any kind of damage to the important information or stealing it other than ensuring the safety of networks and computers. An Ethical Hacker is usually employed by companies to penetrate into networks and/or computer systems, using the same methods as a hacker, for the purpose of finding and fixing network and computer security vulnerabilities. With increasing use of the internet and concerns about its security, especially when it comes to things like consumer information or private details, there is considerable need for computer experts to work in the ethical hacking field. Organizations today recognize the strong need for information security; hence computer systems, using the same methods as a hacker, for the purpose of finding and fixing network and computer security vulnerabilities.\n" +
                "\n" +
                "Learn from one of the Top Cyber Security Expert & Cyber Law Consultant in India, Rizwan Shaikh, for a better quality learning with a practical approach towards learning. Hacking is a skill acquire it before someone else does.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event11);

        EventD event12 =new EventD(13,"Since its creation in 1974, the Rubik's Cube has continued to fascinate, bewilder and challenge millions of people across the world. It is the world's most famous toy/puzzle. Those who can solve the cube say it has increased their self-esteem and made them feel smarter. Whether you solve the Rubik's Cube in ten-seconds or ten minutes, you experience a great sense of accomplishment and pride.\n" +
                "If you know how to solve a Rubik's cube but are unable to showcase your talent, here is the opportunity at the official cubing competition.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event12);

        EventD event13 =new EventD(14,"Fantastic Four Robotics is a two-day workshop in which the trainer would focus on introducing the participants to the world of Robotics. This workshop will take a total time of 16 hours, divided across 2 days. The workshop involves four different sessions in which the participants will be introduced to various concepts related to Robotics and Embedded Systems, DC Motors, Microcontroller, Arduino Boards, IDE Programming Bluetooth Module, Motor Drivers and many more practically.\n" +
                "\n" +
                "At the end of the workshop participants will be able to make their own Gesture controlled, Voice controlled, Bluetooth controlled, Touch Screen controlled and Andriod controlled Robots.","Eligibity: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event13);

        EventD event14 =new EventD(15,"Firstly, learn concepts like ideality, most useful function(s), harmful effects, convolution,\n" +
                "need for invention, the s-shaped curve in innovative design. trimming, miniaturization, etc.\n" +
                "while retaining the functional performance of technical systems (products and processes).\n" +
                "Examples from shown from all areas of engineering.\n" +
                "Learn how to build micro and nanomachines, conceptual &amp; embodiment design, use of\n" +
                "tools, safety precautions, use of creative innovation, psychological inertias.\n" +
                "Design &amp; prototyping of Nano-LED lighted preset torque generating screwdriver for night\n" +
                "repair. Transparent drill bit illuminates the needed area accurately. Extendable to surgical\n" +
                "instruments as well.\n" +
                "Design &amp; build portable, low-cost, folding 2D microscope with nano-LED for detecting\n" +
                "malaria and other diseases through blood samples. Borosilicate ball acts as lens and\n" +
                "gravity-driven focusing mechanism. High-magnification. Originally a Stanford invention, it\n" +
                "has been furthered and cost-cut by Dr Tunde Alowade, PhD (MIT), Co-founder, MIT\n" +
                "ImpactLabs, d-lab fellow, MIT\n" +
                "Design and build a mole/acne friendly shaving razor with so many technical contradictions\n" +
                "resolved. Heated blades cut followed by cold soothing plate, both temperatures attained by\n" +
                "Petlier module. Nano-LED guides contours. Transparent tea-tree natural shaving oil\n" +
                "replaces opaque foam/gel. Segmented and dynamized blades bypass acne/mole without\n" +
                "cut/bruise.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event14);

        EventD event15 =new EventD(16,"This workshop has been designed by engineers and professionals with over years of\n" +
                "experience in the field. Our team consists of engineers from Aerospace, Mechanical,\n" +
                "Electrical and chemical Engineering.\n" +
                "The workshop will house 9 sessions as given in the course content tab. In this workshop\n" +
                "you will learn applications based Design, Manufacturing, Tuning and Flying spanning\n" +
                "over 2 days at Cognizance’18, IIT-Roorkee. The main target of the workshop is to\n" +
                "establish the base which will help you to independently design, build and fly a Tricopter.\n" +
                "The course will give you deep knowledge about the concepts of Aerospace Engineering\n" +
                "like control and stability of Tricopter along with the introduction to rotor dynamics.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event15);

        EventD event16 =new EventD(17,"An embedded system is a computer system with a dedicated function within a larger mechanical or electrical system, often with real-time computing constraints. It is embedded as part of a complete device often including hardware and mechanical parts. Embedded systems control many devices in common use today. 98 percent of all microprocessors are manufactured as components of embedded systems.\n" +
                "\n" +
                "The Intel MCS-51 (commonly termed 8051) is an internally Harvard architecture, complex instruction set computing (CISC) instruction set, single chip microcontroller (µC) series developed by Intel in 1980 for use in embedded systems. The 8051 architecture provides many functions (central processing unit (CPU), random access memory (RAM), read-only memory (ROM), input/output (I/O), interrupt logic, timer, etc.) in one package","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.");
        customList.add(event16);

        EventD event17 =new EventD(18,"Are you fascinated by how Netflix recommends the movies you’ll like or Spotify renders Discover Weekly? Have you wondered what is the Google algorithm that shows you such accurate search results?\n" +
                "Machine Learning is behind these innovations.\n" +
                "The workshop is designed to help participants learn machine learning techniques and algorithms which can be applied using Python. The training program will be entirely based on the use of cases which will give a hands-on learning experience.\n" +
                "The machine learning market size is expected to grow from USD 1.03 Billion in 2016 to USD 8.81 Billion by 2022.","Eligibity: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event17);

        EventD event18 =new EventD(19,"More powerful, more economical and cleaner—the new modular family of engines from Mercedes-Benz offers the right powertrain for every vehicle. While introducing you to everything behind the impeccable systems and the latest features, this workshop also makes sure that the participants return with an impressive garage skillset. Grab this opportunity and test your skills on some of the classiest engines out there.\n" +
                "Mercedes Benz is one of the leading automobile manufacturers in the world which was founded about ninety-one years ago.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event18);
        EventD event19 =new EventD(20,"Internet of Things,or IOT in short, is the idea of making devices and objects smarter by linking them to the internet. This workshop introduces you to the amazing world of IOT and its fascinating applications. Using Arduino development kit, you will develop an electronic device that streams temperature and humidity data over the internet. You can program the system in such a way that say whenever the temperature exceeds a certain limit, the device will automatically send an email notification!","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event19);
        EventD event20 =new EventD(21,"Social Media is an integral part of everyone’s life, every one of us is surrounded by Social networking in some way or other, nowadays we carrying a full-fledged market in our pockets. Let’s understand how you can turn customers through Social Media marketing. People spend twice as much time online and while we say it a lot, the way people shop and buy really has changed, meaning offline marketing isn’t as effective as it used to be. Marketing has always been about connecting with the audience in the right place and at the right time. Today, that means that you need to meet them where they are already spending time: on the internet.\n" +
                "This Workshop explores several aspects of the new Social Media environment including topics such as Social Media Marketing and SEO and use some tools which help you to have a richer understanding of the foundations of the new marketing landscape and acquire a new set of stories, concepts, and tools to help you digitally create, distribute, promote and price products and services.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event20);
        EventD event21 =new EventD(22,"Ycenter is a Global Experiential Education enterprise. Founded in 2013, they have been organizing learning programs and community building exercises in USA, Mozambique, India and Kenya aimed at human-centered problem-solving. In 2015, Ycenter's work was published in a white paper report submitted by Caux Roundtable on the eve of United Nation's Sustainable Development Goals launch. Consequently, for 2 years in 2016 and 2017, they have received invitations to join the High-Level Political Forum event for Partnership Exchange at the UN HQ in New York. Their programs and workshops have also been conducted at top business schools and universities such as Wharton School of Business, Drexel University, NYU, University of Virginia, University of British Columbia, Brown University and Temple University.\n" +
                "On a mission to (re)design modern education systems to promote real-world problem solving, they are currently building a digital platform that can be used by universities, non-profits as well as corporate organizations that are looking to offer their communities with hands-on learning opportunities for Creative Problem Solving & Entrepreneurial Thinking.\n" +
                "\n" +
                "All their programs are crafted using Experiential Learning Pedagogy using Human-Centered Design as a tool to teach Entrepreneurship and Innovation.\n" +
                "Top skills our students gain\n" +
                "1. Complex Problem Solving\n" +
                "2. Critical Thinking\n" +
                "3. Creative Communication\n" +
                "4. Empathy Building and collaboration\n" +
                "5. Business Modeling and pitch using story telling\n" +
                "Learn human-centered design to launch your new enterprise.\n" +
                "This 2-days workshop takes you through the process of Understanding Complex Problems, Empathy building for your customers, Analogous Thinking for Creativity and finally building a Business Model for your best idea.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event21);
        EventD event22 =new EventD(23,"Few words can capture the passion with which someone chooses to venture out in the entrepreneurial field. A startup succeeds on caliber, courage and the right toolkit to set yourself up for success. Well in this workshop you will be able to make applications for Android Devices ranging from Tablets to Smart Phones, You will be making applications which will use Google Maps, Media etc.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event22);
        EventD event23 =new EventD(24,"Sixth Sense Technology is a revolutionary way to aggrandize the physical world around us and let's the user to use natural hand gestures to interact with digital information. It involves almost all sections of modern technology. In this workshop you will be able to make a system that will be color and motion intelligent. Color Sensing & Motion Sensing Bots will be among one of them.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event23);
        EventD event24 =new EventD(25,"Python is fast and easy to use. It cuts development time in half with its simple to read syntax and easy compilation feature. Debugging your programs is a breeze in Python with its built-in debugger.\n" +
                "Python is continued to be a favorites option for data scientists who use it for building and using Machine learning applications and other scientific computations\n" +
                "\n" +
                "Workshop Highlights:\n" +
                "\n" +
                "Exposure to Python Programming Language\n" +
                "Exposure to Graphic User Interface Development\n" +
                "Interactive lecture sessions\n" +
                "Demonstration of the Different Python tools\n" +
                "Group discussions to encourage innovation\n" +
                "Good multimedia content to help students grasp the material easily\n" +
                "Career guidance by experienced faculty","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event24);
        EventD event25 =new EventD(26,"NA",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event25);
        EventD event26 =new EventD(27,"The design of tall buildings essentially involves conceptual design, approximate analysis, preliminary design and optimization to safely carry different loads acting on structure. The structural design for a skyscraper must ensure that the building is able to stand up safely, able to function without excessive deflections or movements which may cause fatigue of structural elements, cracking or failure of fixtures, fittings or partitions, or discomfort for occupants. Tall Building Design Workshop primarily aims at educating the participants about analysis and design of tall buildings.\n" +
                "\n" +
                "Students will be introduced to Structural building engineering and associated software used in tall building design. With the help of various case studies, the participants would be made to understand and develop the skills required for designing tall buildings in the real world. Participants will learn to evaluate different problem statements given to them and so increase proficiency in key civil engineering concepts.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event26);
        EventD event27 =new EventD(28,"Not only India but the whole world, has experienced the emergence of numerous FinTech start-ups, accelerators and incubators over the last few years. India has everything going for it to establish itself as a global FinTech hub. With a large market of underserved/unserved customers, increasing mobile penetration, favourable demographics, an active start-up ecosystem and a large technology talent pool, India has a potential opportunity that is waiting to be seized in the FinTech space. \n" +
                "\n" +
                "Mr Abhishant Pant is a Fintech expert and has more than a decade of hands-on experience of payments landscape. Being enthusiastic about spreading awareness regarding Fintech Mr Pant will be hosting this 10 hrs workshop spread over 2 days, covering not only the concept of Fintech, but will also cover the building of startup brand on social media and the most talked concept of Blockchain.\n" +
                " ","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event27);
        EventD event28 =new EventD(29,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event28);
        EventD event29 =new EventD(30,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event29);
        EventD event30 =new EventD(31,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event30);
        EventD event31 =new EventD(32,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event31);
        EventD event32 =new EventD(33,"Armageddon is a combat robotics championship, where two custom-built machines use varied methods of destroying or disabling the other. Armageddon promises to be an ultimate battlefield where the bots fight for life, and in the end it is going to be “Survival Of The Fittest’’. Here at Armageddon, we bring forth you Darwin’s Theory Of Natural Selection being applied to the non-living. When all the bots perish into the grave it would be one bot that stands up to all the challenges to become the ultimate combat bot.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "A team can have a maximum of 5 members.\n" +
                "The maximum duration of round 1 is 3 minutes and that of round 2 will be 5 minutes. Any team that is not ready at the time specified will be disqualified. \n" +
                "Immobility (if a robot is unable to travel for at least 10 cm for 15 seconds) would lead to disqualification.\n" +
                "If the wires of any two or more robots get entangled, the match shall be paused and the wires will be freed. Subsequently, the bots will be placed in their respective positions at the time of pausing the match. \n" +
                "Repairing the robot during the match is not allowed. However, in case the bot is damaged in such a way that it, in turn, is damaging the arena, then the bot shall be modified/repaired as required to prevent any further damage to the arena. \n" +
                "All decisions concerning mid-match modifications and repairs MUST HAVE the consent of the event organizers. \n" +
                "No participants will be allowed to enter the arena during the duration of the match. All repairs and manual reset during the match, if any, will be performed by members of the organizing team only.\n" +
                ""           ,
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it."
        );
        customList.add(event32);
        EventD event33 =new EventD(34,"Has the flight of an airplane ever fantasized you? Are the Wright brothers your role model? So here comes Cognizance-2018 with AERONAVE, an event providing all the aero modelers a platform to quench their dreams. An event where we call upon engineers and aero designers to design a RC powered electric motor aircraft and put their skills and technicality to the test. The event includes not only flight but also coupled with a series of hurdles, a real test of aero modeling expertise.\n" +
                "So, give your imaginations wings. Build your own RC aircraft and soar high up in the sky.\n" +
                " ",

                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Any undergraduate or masters student of any discipline is eligible to participate in this event.\n" +
                "Maximum number of members in the team must not exceed 5.\n" +
                "The models can have powered take-off with a landing gear or can be launched manually by a person standing at ground level.\n" +
                "Plane should be built from scratch and not a purchased models.\n" +
                "A participant can’t be a part of more than one team."
        );
        customList.add(event33);
        EventD event34 =new EventD(35,"The objective of this event is to promote cities that cater core infrastructure and provide its citizens a decent quality of life, a clean and sustainable environment and application of ‘Smart Solutions’. The CITY OF SMART CLANS, undoubtedly a new and bold initiative, has a committed vision to establish examples that can be presented as models to be replicated both within and outside the Smart City. Each team has to build a smart city model which can fulfil all the requirements of citizens in an eco-friendly way.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Each team can have a maximum of 4 participants and minimum of 2 participants.\n" +
                "All the materials needed will be provided on spot.\n" +
                "All the other rules of this event will be given to each team just before ½ hour from the beginning of the event.\n" +
                " "
        );
        customList.add(event34);
        EventD event35 =new EventD(36,"National Mission for Clean Ganga (NMGC) is the implementation wing of National Ganga River Mission Authority (NGRMA). To help them in the mission to clean the Ganga, they need to perform extensive research of the river. Some locations aren’t easily accessible to humans. Lucky for us, a quadcopter can be quite handy in these situations. Build an innovative Quad with a sleek and aesthetic design to help them out. Quad should be efficient on all fronts and it must have considerable structural integrity. Have your team brainstorm about the prototypes of the Quad to inculcate a design with inputs from the members. Power your Quad through all the hurdles and loops to be crowned the winner.\n" +
                " ",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.",
                "A team can take part with only one quadcopter.\n" +
                        "A quadcopter cannot be shared between two or more teams.\n" +
                        "A team should comprise of at the most 5 members.\n" +
                        "Participants shall not be allowed to be part of more than one team.\n" +
                        "Quad should fit into the dimension box of 450mm x 450mm x 350mm.\n" +
                        " "
        );
        customList.add(event35);
        EventD event36 =new EventD(37,"This is year 2050. ISRO has already set up its base station on Mars and is undergoing its secret military nuclear research programs. But unfortunately the Martians have captured all the base station there and taken over all the weapons, which could possess potential harm to Earth. Now ISRO has come-up with an idea to send a team on Mars to detonate all the nuclear weapons and save the mother EARTH.\n" +
                "Now you as a part of the Taskforce team have to come up with your best bots that can sustain the harsh conditions of Mars and also pass through all the hurdles and finally show the Martians that WHO IS THE BOSS!\n" +
                "\n" +
                "The residents of Uttarakhand will be directly shortlisted for the state-level India Skill Program organized by UKSDM.\n" +
                " ",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Any student of undergraduate/postgraduate (excluding PhD.) program at any recognized institute (identity card will be checked) are eligible to participate.\n" +
                "A team can consist of a maximum of 5 members.\n" +
                "Each team must declare a name for their team at the time of competition.\n" +
                "The robots must not contain any combustible, corrosive, or otherwise dangerous materials for safety reasons. No explosive compression or decompression, either internal or external is permitted.\n" +
                "Coordinators have the right to disqualify any team whose working mechanism or game strategy is considered hazardous in any way.\n" +
                "In case any kind of dispute arises the Coordinator’s decision will be considered final and binding to all and no argument will be entertained."

        );
        customList.add(event36);
        EventD event37 =new EventD(38,"The event is an attraction for all the gamers out in the country to showcase their talent of getting out through the hurdles in a given time. It will be a competition amongst a set of professional gamers who come from different parts of the country. Calling out all the gamers out there to showcase their talent of gaming in Counter Strike and prove their mettle in this field.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Teams can consist of 5 members each. \n" +
                "Three maps will be played between the two teams.\n" +
                "All matches are played using the Max Rounds 15 scoring system. Each map will be played one time as CT and one time as T, which will be decided by a knife round at the starting of the map.\n" +
                " "

        );
        customList.add(event37);

        EventD event38 =new EventD(39,"The event is an attraction for all the gamers out in the country to showcase their talent of getting out through the hurdles in a given time. It will be a competition amongst a set of professional gamers who come from different parts of the country. Calling out all the gamers out there to showcase their talent of gaming in DOTA 2 and prove their mettle in this field.\n" +
                " ",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Teams can consist of 5 members each. \n" +
                "Captain’s mode only (ban time and pick time as described in latest map).\n" +
                "Latest version and map, available, will be played.\n" +
                "A game is finished, when an Ancient Fortress is destroyed, when one team obviously forfeits, when the majority of a team leaves on purpose, or when the administration decides on it. \n" +
                " "

        );
        customList.add(event38);


        EventD event39 =new EventD(40,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event39);

        EventD event40 =new EventD(41,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event40);

        EventD event41 =new EventD(42,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event41);

        EventD event42 =new EventD(43,"We have all overheard conversations, walking down hip streets of the world’s tech capitals, discussions about how savvy is the ‘UX’ of the latest gizmos, or the poor ‘UI’ of a website. These acronyms, small yet carrying impetus, are tossed around carelessly in conversation without actual comprehension. The people you have eavesdropped on are actually discussing two professions, that despite having been around for decades, and in theory for centuries, have been defined by the tech industry as UI/UX design. Hence this year Cognizance in collaboration with Redd, \"Company of the year 2017\"- Silicon India Magazine, are calling out all developers who are excited to share what they see the world as and win exciting prizes for it.\n" +
                "\n" +
                " ",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Mail your entries to support@redd.in or events@cognizance.org.in before March 14, 11:50 PM.\n" +
                "Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Multistage Rules: The event will be conducted in 3 rounds.\n" +
                "Participants can take part as individuals or in a group of maximum 3 members.\n" +
                " "

        );
        customList.add(event42);

        EventD event43 =new EventD(44,"The event is an attraction for all the gamers out in the country to showcase their talent of getting out through the hurdles in a given time. It will be a competition amongst a set of professional gamers who come from different parts of the country. Calling out all the gamers out there to showcase their talent of gaming in FIFA and prove their mettle in this field. ","Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
        "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event43);


        EventD event44 =new EventD(45,"The event is an attraction for all the gamers out in the country to showcase their talent of getting out through the hurdles in a given time. It will be a competition amongst a set of professional gamers who come from different parts of the country. Calling out all the gamers out there to showcase their talent of gaming in NFS Most Wanted and prove their mettle in this field.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event44);

        EventD event45 = new EventD(46,"","","");
        customList.add(event45);


        EventD event46 = new EventD(47,"","","");
        customList.add(event46);


        EventD event47 =new EventD(48,"In regards to a particular product or service, this means the adaptation of globally marketed products and services into local markets. A global product or service, something everyone needs and can get use out of, may be tailored to conform with local laws, customs, or consumer preferences. This case study event will test your marketing skills If you think you have that \"Globalised Local Skills\" in you, Register for Glocalisation.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event47);


        EventD event48 =new EventD(49,"The event is an attraction for all the gamers out in the country to showcase their talent of getting out through the hurdles in a given time. It will be a competition amongst a set of professional gamers who come from different parts of the country. Calling out all the gamers out there to showcase their talent of mobile gaming in Clash Royale and prove their mettle in this field.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event48);

        EventD event49 =new EventD(50,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event49);


        EventD event50 =new EventD(51,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event50);


        EventD event51 =new EventD(52,"As Kulshreshtha of Genpact has rightly said, Analytics and business intelligence have become “competitive differentiators”, institutes have understood the importance of getting students analytics-ready right from the academic level. This competition will test participants’ knowledge on analytics and more importantly their analytical skills.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event51);


        EventD event52 =new EventD(53,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event52);


        EventD event53 =new EventD(54,"Effigy is a model making event which deals with the making of paper structures of given dimensions tested under the load.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event53);

        EventD event54 =new EventD(55,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event54);


        EventD event55 =new EventD(56,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event55);

        EventD event56 =new EventD(57,"Are you the friend who influences his group to watch a particular movie? Have you convinced a faculty to delay a certain surprise test? Do you talk about brands passionately influence the purchases of your friends? Then Saleution is for you. We all sell something, be it products, services, apps, ideas or social causes. Saleution provides you a platform to put your communication and negotiation skills to test. Compete to test your brand knowledge in a time when brands are gaining near cult-like status. \" Don't sell products or services, Sell solutions\". This is the aim of Saleution, to see who can understand the underlying motivations that make any kind of sales process successful. ",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event56);

        EventD event57 = new EventD(58,"","","");
        customList.add(event57);


        EventD event58 = new EventD(59,"","","");
        customList.add(event58);



        EventD event59 =new EventD(60,"Have you come across a point where you think you are the most confident person in the universe? Let’s test what you got! Karyaneeti is an event organized by VyavaHR Club of DoMS, IIT Roorkee. It’s an event to check your interpersonal skills, analytical skills, thought process and the qualities which you think you have.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );

        customList.add(event59);



        EventD event60 =new EventD(61,"This event will take you through the rollercoaster ride of product, its procurement, its marketing strategy, its sales target, its after-sales service. First, you need to frame a Questionnaire as a part of online survey round, based on the response you get for the questions. You would be analyzing and designing a product suitable for the needs of the customer and if you artistic and dexterous personality, you would part of its designing product’s digital marketing campaign.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event60);

        EventD event61 =new EventD(62,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event61);


        EventD event62 =new EventD(63,"The 'future' must know its future! Hence present students must know all about Artificial Intelligence. Cognizance, thus invites AI enthusiasts to \"discover\" wonders in Alan Turing's \"dream\". Cognizance in association with Microsoft Technology Associates presents Verzeo AI Algorithm Challenge, in which the participants are required to build an AI service which reduces human effort in web technologies. The students are required to develop AI algorithm specifically focusing on improving learning outcomes, using personalised data analytics, for students any level of ability or any kind of AI services which can make students learning more interactive and fun based. Register now to participate in this event and win a mouth-watering prize money of INR 1.5 lacs and Internship opportunities at Microsoft.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" + "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event62);


        EventD event63 =new EventD(64,"Most of us at some point in time would have acted as a consultant to our friends, family, relatives or some peers. Similarly, organizations face a number of risks related to finance, business processes, technology, and operations, and it's the job of a consultant to help them effectively manage those risks. If you think that you possess this virtue of being a problem solver, then Corpostrat is the event where you could challenge yourself and strive to prove your mettle.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event63);

        EventD event64 = new EventD(65,"","","");
        customList.add(event64);



        EventD event65 =new EventD(66,"If you think you have the best coding skills in the town or if you are a starter and you are willing to compete against the very best of coding, then you are at the right place! Here we bring to you a programming contest \"Mindsweeper\", where you get to compete with the best coders all over India.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event65);

        EventD event66 =new EventD(67,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event66);

        EventD event67 = new EventD(68,"","","");
        customList.add(event67);

        EventD event68 =new EventD(69,"The event is an attraction for all the gamers out in the country to showcase their talent of getting out through the hurdles in a given time. It will be a competition amongst a set of professional gamers who come from different parts of the country. Calling out all the gamers out there to showcase their talent in mobile gaming of Mini Militia and prove their mettle in this field.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event68);


        EventD event69 =new EventD(70,"It is on-spot event under Management Studies.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event69);

        EventD event70 =new EventD(71,"Finance is not merely about making money. It's about achieving our deep goals and protecting the fruits of our labor. It's about stewardship and, therefore, about achieving the good society. Finance can also be defined as the science of money management. Market participants aim to price assets based on their risk level, fundamental value, and their expected rate of return. Finnacle is an opportunity for every finance enthusiast to participate, learn, and test their knowledge and to prove their mettle in the field of finance and accounting.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event70);

        EventD event71 =new EventD(72,"Can you manage the future of an organization by ensuring that the supply and demand are satisfied? Test your ability by participating in “Opstruct” and prove that you can save thousands of Dollars by being an effective Operations Manager of an organization. An Online Quiz and the famous “Beer Game” will be used to determine the knowledge and effectiveness of a team. The quiz will have questions on Operations Management and “The Beer Game” will be live simulation performed by the team of 4 members simulating the Producer, Distributor, Wholesaler and the Retailer of a Beer Supply Chain.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event71);

        EventD event72 =new EventD(73,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event72);


        EventD event73 =new EventD(74,"Yin Yang is all about presenting two interconnected endings to a same story. A common famous story would be given to the participants and they will have to give two entirely different climaxes to it. The required stationary would be given to the participants before the competition itself. ",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event73);

        EventD event74 =new EventD(75,"\"Grab as much as you can and if you grab what conquers the world, Then there is no end to your legacy.\" With this said we invite you to a journey so bewildering, you savor every moment and wish that it never gets over. Are you the one with an appetite to earn and zealous enough to sell your own house. Brace for the stunning real time decision making , bidding and hustling. Adapt or die is our motto coz its \"Rush Hour\"",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event74);


        EventD event75 = new EventD(76,"","","");
        customList.add(event75);



        EventD event76=new EventD(77,"Travelogue writing competition which encompasses outdoor literature, guide books, nature writing, and travel memoirs. "," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event76);

        EventD event77 = new EventD(78,"","","");
        customList.add(event77);



        EventD event78 =new EventD(79,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event78);

        EventD event79 =new EventD(80,"\"KRITI\" is a Component-Designing, CAD-based event of the annual technical fest COGNIZANCE-218. Kriti is conducted by AHEC department for all the creative enthusiasts to showcase their talent and designing skills to compete amongst the top creative designers from all over the country. This event will be conducted in two stages. In stage-1 participants are requested to send the files containing their designs as per given instructions and shortlisted candidates for stage-2 will be informed through mail. For stage-2 problem will be given on the spot to be solved in the stipulated time during the tech-fest under the constraint of the rules.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event79);


        EventD event80 =new EventD(81,"Blue Book is a picture identification event for Small Hydropower Plants similar to a picture quiz.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event80);


        EventD event81 =new EventD(82,"Today we live in a Data-driven economy, so we believe that taking a data-based approach is the need of the hour. Since its inception Cognizance has been taking up various out of the box events for to check various burning issues in the society. This year too, our team has come up with this data-based event “ DataQuest”, on Road Safety.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event81);


        EventD event82 = new EventD(83,"","","");
        customList.add(event82);


        EventD event83 =new EventD(84,"Quizonomics 1.0 is the general quiz with a blend of Economics.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event83);

        EventD event84 =new EventD(85,"Pitney Bowes and Cognizance, IIT Roorkee present the B2SMB challenge which encourages you to create high-impact mobile applications for close to half-billion Small and Medium Businesses (SMBs) in the world!",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event84);

        EventD event85 =new EventD(86,"Ideaz is an international level paper-presentation event, a perfect extension of our theme, \"Dreaming Discoveries\". A platform to turn into reality, your thoughts, your ideas and more importantly your dreams. If your idea is really the next Eureka moment, we will make it our priority to let the world know."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"

        );
        customList.add(event85);


        EventD event86 =new EventD(87,"India Film Project brings to you a 24-hour filmmaking competition set to take place during Cognizance 2018.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event86);
        EventD event87 =new EventD(88,"The aim of the competition is to provide students with an opportunity, in a team-oriented hands-on design and construction of a small chemically powered car. It tests the ability of the participants to safely control and harness the energy of a chemical reaction by initiating the car and allowing it to traverse a fixed distance carrying/pulling a certain load.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event87);

        EventD event88 =new EventD(89,"Bookworms, nerds, geeks and geniuses, you can find them all at this supreme confluence of the best minds and quizmasters from all over the country! A Quiz is more than just a collection of questions in search of answers. It is a reflection of the times we live and have lived in.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event88);

        EventD event89 = new EventD(90,"","","");
        customList.add(event89);

        EventD event90 = new EventD(91,"With Cognizance 2018 returns the eighth edition of the IITR MUN, an event centered on knowledge and designed to cultivate public speaking. It promises to ignite minds and foster debates on the most critical issues that define the world that we live in. With two committees running parallel to each other, we plan to reach out to the best thinkers and debaters from across all colleges."," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" + "Team Size: Maximum size up to 5 members.\n");
        customList.add(event90);


        EventD event91 =new EventD(92,"With Cognizance 2018 returns the eighth edition of the IITR MUN, an event centered on knowledge and designed to cultivate public speaking. It promises to ignite minds and foster debates on the most critical issues that define the world that we live in. With two committees running parallel to each other, we plan to reach out to the best thinkers and debaters from across all colleges.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.",
                "Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" + "Team Size: Maximum size up to 5 members.\n");
        customList.add(event91);


        EventD event92=new EventD(93,"Surrealist works feature the element of surprise, unexpected juxtapositions and non-sequitur; however, many Surrealist artists and writers regard their work as an expression of the philosophical movement first and foremost, with the works being an artefact.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event92);


        EventD event93 = new EventD(94,"","","");
        customList.add(event93);


        EventD event94=new EventD(95,"Quiziline is general quizzing event of chemistry. Exercise your brain in the general quiz competition. No prerequisites, except your zest to know more.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event94);

        EventD event95 =new EventD(96,"Participants are invited to present a solution to the problems improving accessibility for all and providing convenient integration of all the modes by their innovative ideas via poster made on a sheet.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event95);

        EventD event96 = new EventD(97,"","","");
        customList.add(event96);


        EventD event97 = new EventD(98,"","","");
        customList.add(event97);


        EventD event98 =new EventD(99,"Quizotropy is the quiz based on basic concepts of materials.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event98);

        EventD event99 =new EventD(100,"On the spot event.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event99);

        EventD event100 =new EventD(101,"The Event is basically a general quiz which revolves around the practical applications of civil engineering followed by a surprise round whose details will be revealed on the spot.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event100);

        EventD event101 =new EventD(102,"On-spot quizzing event.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Will have two rounds of quizzes. The first would be a pen and paper round and the second a buzzer round where you will be asked questions that will have some relevance to the field of computer science."  );
        customList.add(event101);

        EventD event102 = new EventD(103,"","","");
        customList.add(event102);


        EventD event103=new EventD(104,"You are required to solve either of the given problems, using CAD software, to qualify to the final round; however solving both the problems gives you an advantage.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event103);


        EventD event104 = new EventD(105,"","","");
        customList.add(event104);


        EventD event105 =new EventD(106,"Insomnia is a nocturnal coding challenge which involves all kinds of algorithmic challenges, widely ranging from basic string manipulations to complex dynamic programming. The given tasks can be accomplished in any coding language which best suits the participant. The tournament consists of different stages with increasing level of adversity as the participant progresses. Insomnia is definitely a hot spot among online events.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event105);


        EventD event106 =new EventD(107,"An online cryptography contest which demands the sound use of eyes and brain combined with Google for solving the mind boggling levels of puzzles. Logical analysis of the combination of 2 or more images serves as the hint to get through the question and unblock the subsequent level. Held for a span of 48 continuous hours, Illushun witnesses participation from every nook and corner of the globe.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event106);

        EventD event107 =new EventD(108,"Nanotechnology is a highly interdisciplinary field and is considered to be a confluence of engineering, technology and pure sciences such as physics, chemistry, biology and material sciences. Students who are interested in pursuing a career in Nanotechnology must be willing to learn from different fields. This event will take you through the same.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event107);

        EventD event108 = new EventD(109,"","","");
        customList.add(event108);

        EventD event109 = new EventD(110,"","","");
        customList.add(event109);



        EventD event110 =new EventD(111,"The Government of Uttarakhand intends to harness the full power of Information and Communication Technology (ICT) for improving the quality of life of its citizens, bring in accelerated social and economic development, ensure transparency in the Government decisions, accelerate the IT adoption amongst various user segments – all leading to an ideal e-society model through efficient, Service-oriented, cost-effective, information networked, eco-conscious, and with year-on-year growth approach. With this background, Department of Information Technology (DoIT), Government of Uttarakhand (GoUK) intends to build a brand for ‘Digital Uttarakhand’ through an Open Online Competition organized by Cognizance, IIT Roorkee. The DoIT, GoUK is desirous to give an identity to the Digital Uttarakhand initiatives by having its brand name, common name, acronym, letterhead design and logo. In order to get fresh ideas the DoIT, GoUK has decided to launch a contest among the students of public & private sector academic institutions & companies in IT Sector.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event110);

        EventD event111 = new EventD(112,"","","");
        customList.add(event111);


        EventD event112=new EventD(113,"For all the science aficionados and budding technocrats, we bring to you, Spectrum- A ChemEquiz, this tech-season. Spectrum gives you the opportunity to hone your scientific thinking. With certain questions specific to Chemical Engineering, the Spectrum is open to all and covers a diverse range of topics other than Chemical Engineering. So, if science gives you an adrenaline rush, add Spectrum to your schedule. Quizzing is not just about GK, but about Connecting the dots, reading between the lines and arriving at a conclusion. It needs to focus on logical reasoning.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event112);

        EventD event113 =new EventD(114,"Think you’re as good a detective as Sherlock? Well, come on and find out at the Mineral Hunt! This is a Treasure Hunt with a rocky twist that we’re sure will keep you at wits end. So come on and prove yourself as the best Mineral Hunter!",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event113);

        EventD event114 = new EventD(115,"","","");
        customList.add(event114);


        EventD event115 =new EventD(116,"BackdoorCTF is an open hacking challenge for the genius minds in the world of coding to prove their mettle and decipher the answers to the puzzles presented to them. It is a ‘Capture the Flag’ styled event. A flag (basically a string) is associated with every challenge. Once the participants have solved a particular challenge, they will get a hidden flag which they need to submit back to get points. The areas covered while designing the challenges are reverse-engineering, network sniffing, protocol analysis, web security, system administration and cryptanalysis.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event115);


        EventD event116 =new EventD(117,"The event consists of fun-filled quizzes, explanations and an exciting game. You stand the chance to have great fun and win exciting prizes.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event116);

        EventD event117 = new EventD(118,"","","");
        customList.add(event117);


        EventD event118 =new EventD(119,"Whether it’s self-publishing or traditional, there is no greater thrill than seeing your words in print ready for the world to read.In a world full of competition between budding writers in order to get published,having a publisher at one’s doorsteps is completely luck of the draw. "," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event118);


        EventD event119 =new EventD(120,"The performers can voice out their thoughts to the masses and, at the same time, can listen thousands of voices which may help them understand the world better. "," Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
        "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event119);
        EventD event120 =new EventD(121,"It is a two-day interactive session by British Council, a British organization specializing in international cultural and educational opportunities. The workshop aims at familiarising the participants with the services provided by British Council, including Mix The City and Mix The Body apps. Also, the workshop will introduce the participants to IELTS and its preperation.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event120);

        EventD event121 =new EventD(122,"The scale of urban expansion in India is large and will continue to be enormous, driven by economic and population growth. The construction and use of buildings, driven by rapid urban expansion, is likely to impose tremendous pressures on natural environment. Not only this, but this tremendous growth will increase the demand for affordable housing as well. Today’s infrastructure investments will play a critical role in determining future resource intensity and affect India’s ability to decouple resource consumption from economic growth. Urbanisation in India is less advanced than in many other countries, which presents an opportunity to avoid being locked into energy- and resource-intensive infrastructure. The promotion of green buildings, which has already begun in India, offers one way to achieve this.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event121);


        EventD event122=new EventD(123,"Bamboo is also being used to make furniture. Not only is it aesthetically sound but also it goes hand in hand with the design of the room in general on numerous occasions. The main objective of this competition is to build a uniquely designed swing using bamboo on a 1:1 scale without digging the ground. The creativity and skill of the product shall be main criteria for evaluation.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event122);


        EventD event123=new EventD(124,"Send us five high quality architectural photographs depicting your understanding of the subject with a 50 word caption/write up to explain the same.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event123);


        EventD event124 =new EventD(125,"Cognizance has been operating PAN-India in collaboration with various government ministries, endeavoring to deliver on causes related to environmental sensitization, women empowerment, and mental health awareness.The Reinvent Bio-Toilet challenge is a result of our vision to improve the deteriorating condition of River Ganga and the sanitation of Ghats on its banks under our initiative Aviral Ganga. Concerns about the condition of the Ganges were raised for decades which gained impetus in the past few years owing to awareness and support from keen environmentalists. The declared failure of the Ganga Action Plan by various scientists and NGO’s has strengthened our cause. We hope that we will be able to provide innovative, reliable and implementable solutions through this case study challenge.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event124);


        EventD event125 =new EventD(126,"“The only thing that is constant is change” – These words not only reflect a truth of our personal lives, but also a necessity for survival in the world of business. Every industry, over its course, goes through a series of changes – be it due to technology, demand, consumer behaviour, political or competitive environment. And to survive such changes, it becomes imperative for a business to adapt and innovate. The Energy Industry is not indifferent to this rule. Cognizance in association with Schlumberger is providing this platform to the enthusiastic students who plan and work for a sustainable future. The problem statement would be uploaded by tomorrow. Stay tuned!",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event125);





        EventD event126 =new EventD(127,"The aim of the problem is to develop a forecasting model to predict a stock's short-term price movement. The use of such prediction models is widely prevalent in algorithmic trading. Algorithmic trading, sometimes referred to as high-frequency trading in specific circumstances, is the use of automated systems to identify true(money making) signals among massive amounts of data that capture the underlying stock dynamics. These models can be leveraged to develop profitable trading strategies(akin to hedge funds) to help investors/traders achieve better returns. Contestants are expected and encouraged to think of empirical models/heuristics in order to better predict the price evolution of the hypothetical stock.",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event126);



        EventD event127 =new EventD(128,"Like the perfection of Mozart and finesse of Picasso, speed typing is no less of an artist's work. If you are willing to prove the rhythm of your mind clocks and the efficiency of your finger-strokes, crack up your knuckles, a storm of efficient programmers are on their way for a keyboard duel. Do you think that you are the fastest typer? Measure your typing speed and challenge your friends to an ultimate battle of SpeedRacers",
                " Go to your Dashboard and find the event under Centerstage Events, then Register for it.","Eligibility: Student pursuing Undergraduate/Master’s Degree in any discipline.\n" +
                "Team Size: Maximum size up to 5 members.\n"
        );
        customList.add(event127);


        EventD event128 =new EventD(129,"NA",
                " The contest will be held online and on-site simultaneously. Participants present at Cognizance will be eligible to participate on-site in this contest. Registration on the online platform will serve sufficient for being an eligible participate. Contest url: http://hck.re/c20186. Contest Date:19th March 2018(9:30PM IST - 12:30AM IST)","1- Please refrain from discussing strategy during the contest. 2-All submissions are run through a plagiarism detector. Any case of code plagiarism will disqualify both users from the contest. 3- Each challenge has a pre-determined score. 4-Your score for a problem depends on the number of test cases your submission successfully passes. 5-A participant's total score is the sum of the scores earned for each problem attempted. If you submitted more than one solution for a problem, only your highest score achieved will be used in this calculation. 7-Participants are ranked by score, with the cumulative time taken (between the contest's start time and the time of your correct submission) used to break ties. 8-Please do not discuss strategy, suggestions or tips in the comments during a live contest. Posting questions clarifying the problem statement is ok. If you are unsure, email us at cse@cognizance.org.in"
        );
        customList.add(event128);



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
        btn =(Button)findViewById(R.id.register);
        introText =(TextView)findViewById(R.id.info);
        registrationText = (TextView)findViewById(R.id.registrationProcedure);
        rulesText =(TextView)findViewById(R.id.rulesAndRegulation);
        problemText=(TextView)findViewById(R.id.problemStatment);
        contactText=(TextView)findViewById(R.id.contactDetails);
        event=(TextView)findViewById(R.id.event_name);
        imageView = (ImageView)findViewById(R.id.image);
    }

}
