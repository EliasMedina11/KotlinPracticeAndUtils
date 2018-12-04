import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.cursokotlin.pruebakotlin.R
import com.cursokotlin.pruebakotlin.R.id.tvRealName
import com.cursokotlin.pruebakotlin.R.id.tvSuperhero
import com.cursokotlin.pruebakotlin.Superhero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*

class RecyclerAdapterSuper : RecyclerView.Adapter<RecyclerAdapterSuper.ViewHolder>() {

    var superheros: MutableList<Superhero> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(superheros: MutableList<Superhero>, context: Context) {
        this.superheros = superheros
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero_list, parent, false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val realName = view.findViewById(R.id.tvRealName)
        val publisher = view.findViewById(R.id.tvPublisher)
        val avatar = view.findViewById(R.id.ivAvatar)

        fun bind(superhero: Superhero, context: Context) {
            tvSuperhero.text = superhero.superhero
            tvRealName.text = superhero.realName
            publisher.text = superhero.publisher
            avatar.loadUrl(superhero.photo)
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superhero, Toast.LENGTH_SHORT).show() })
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}