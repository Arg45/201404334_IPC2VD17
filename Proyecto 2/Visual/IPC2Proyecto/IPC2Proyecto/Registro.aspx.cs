using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace IPC2Proyecto
{
    public partial class Registro : System.Web.UI.Page
    {
        //localhost.Usuario u = new IPC2Proyecto.localhost.Usuario();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btt_registrar_Click(object sender, EventArgs e)
        {
            localhost.Usuario u = new localhost.Usuario();

            u.AgregarUsuario(txt_nombre.Text, txt_email.Text, txt_nac.Text, txt_nick.Text, txt_pass.Text, txt_karma.Text);

            limpiarTXT();
        }
        protected void limpiarTXT() {
            txt_nombre.Text = " ";
            txt_email.Text = " ";
            txt_nac.Text = " ";
            txt_nick.Text = " ";
            txt_pass.Text = " ";
            txt_karma.Text = " ";
        }


    }
}