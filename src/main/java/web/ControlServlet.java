package web;

import Data.ClientDAO;
import Domain.Client;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.getUpdateData(request, response);
                    break;
                case "delete":
                    this.deleteClient(request, response);
                    break;
                default:
                    this.mainAction(request, response);
            }
        } else {
            this.mainAction(request, response);
        }
    }

    private void getUpdateData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = Integer.parseInt(request.getParameter("clientId"));
        ClientDAO clientDAO = new ClientDAO();
        Client client = clientDAO.getClientById(new Client(clientId));

        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/pages/client/clientUpdate.jsp").forward(request, response);
    }

    private void mainAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = new ArrayList<>();
        ClientDAO clientDAO = new ClientDAO();
        clients = clientDAO.getClients();

        HttpSession session = request.getSession();

        session.setAttribute("clients", clients);
        session.setAttribute("totalClients", clients.size());
        session.setAttribute("totalResidue", this.getTotalResidue(clients));

        //request.getRequestDispatcher("clients.jsp").forward(request, response);
        response.sendRedirect("clients.jsp");
    }

    private double getTotalResidue(List<Client> clients) {
        double total = 0;

        for (Client client : clients) {
            total += client.getResidue();
        }

        return total;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    this.addClient(request, response);
                    break;
                case "update":
                    this.updateClient(request, response);
                    break;
                default:
                    this.mainAction(request, response);
            }
        } else {
            this.mainAction(request, response);
        }
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientDAO clientDAO = new ClientDAO();

        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Double residue = Double.parseDouble(request.getParameter("residue"));

        Client client = new Client(name, lastname, email, phoneNumber, residue);
        int affectedRows = clientDAO.insertClient(client);

        if (affectedRows > 0) {
            System.out.println("Client added successfully");
        } else {
            System.out.println("Client not added!");
        }

        this.mainAction(request, response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int clientId = Integer.parseInt(request.getParameter("clientId"));
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        double residue = Double.parseDouble(request.getParameter("residue"));

        Client client = new Client(clientId, name, lastname, email, phoneNumber, residue);
        ClientDAO clientDAO = new ClientDAO();

        int affectedRows = clientDAO.updateClient(client);

        if (affectedRows > 0) {
            System.out.println("Client updated successfully");
        } else {
            System.out.println("Client not updated!");
        }

        this.mainAction(request, response);
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int clientId = Integer.parseInt(request.getParameter("clientId"));
        
        Client client = new Client(clientId);
        ClientDAO clientDAO = new ClientDAO();

        int affectedRows = clientDAO.deleteClient(client);

        if (affectedRows > 0) {
            System.out.println("Client deleted successfully");
        } else {
            System.out.println("Client not deleted!");
        }

        this.mainAction(request, response);
    }
}
