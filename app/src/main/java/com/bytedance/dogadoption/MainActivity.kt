package com.bytedance.dogadoption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list)

        val adapter = SearchAdapter()
        //  RecyclerView 绑定 Adapter
        list.adapter = adapter
        //  RecyclerView 绑定纵向布局管理器
        list.layoutManager = LinearLayoutManager(this)

        val items = ArrayList<item>()
        items += item(R.drawable.chillchili, "NAME: chillchili\n\nGROUP: Toy (AKC)" +
                "\n\n" +
                "HEIGHT: Under 10 inches\n" +
                "\n" +
                "WEIGHT: Under 6 pounds",
                "Known for their intelligence, athleticism, and sociability, poodles make amazing family dogs. Teacup poodles usually weigh about 4 pounds, while their standard-sized counterparts weigh 45 to 70 pounds. One convenient trait of poodles? They're low-shedders. Their curled coats don't drop much hair, which is great news for your allergies and your vacuum cleaner.")
        items += item(R.drawable.coco, "NAME: coco\n\nGROUP: Toy (AKC)\n" +
                "\n" +
                "HEIGHT: Under 7 inches\n" +
                "\n" +
                "WEIGHT: Under 7 pounds\n"

                , "Not only is the Maltese one of the world's oldest breeds—originating almost 3,000 years ago—but it also was considered royalty back in the day. The teacup variety generally weighs between 2 and 4 pounds. Because of their small size and low energy, these dogs are a good fit for people who want a cuddle buddy")
        items += item(R.drawable.mochi_mini,"NAME: mochi_mimi\n\nGROUP: Toy (AKC)\n" +
                "\n" +
                "HEIGHT: Under 7 inches\n" +
                "\n" +
                "WEIGHT: Under 7 pounds","Although today's Pomeranians have a reputation as lapdogs, they were originally bred to herd animals and pull sleds. Earlier versions of the Pomeranian breed weighed around 30 pounds. In the 1800s, they were bred to be smaller to be kept as companions rather than working dogs. Since then, they've only gotten smaller."
                )
        items += item(R.drawable.sebastian,"NAME: Sebastian\n\n"+ "GROUP: Not an AKC-recognized breed\n" +
                "\n" +
                "HEIGHT: Up to 10 inches (toy)\n" +
                "\n" +
                "WEIGHT: Up to 9 pounds (toy)", "As its name suggests, the Pomsky is the cross between a Siberian husky with a Pomeranian. Pomskies tend to vary in size depending on how much of each breed they have in them. This mix tends to have a high energy level, so be prepared for lots of walks and play."
                )


        //  刷新列表项
        adapter.updateItems(items)
        val context = this //?
        adapter.setListener(object : SearchAdapter.itemListener {

            override fun onClick(position: Int) {
                val intent = Intent(context, ImformationActivity::class.java)
                intent.putExtra("dogImage",items[position].imageResource)
                intent.putExtra("dogImformation",items[position].Imformation)
                startActivity(intent)
            }

        })

        val searchEdit = findViewById<SearchEditText>(R.id.search_edit)
        searchEdit.addTextChangedListener(object : SearchEditText.Listener {
            override fun onChanged(content: String) {
                //  过滤列表项
                val filters = items.filter {
                    it.text.contains(content)
                }
                adapter.updateItems(filters)
            }
        })

        val cancel = findViewById<TextView>(R.id.cancel)
        cancel.setOnClickListener {
            finish()
        }
    }
}