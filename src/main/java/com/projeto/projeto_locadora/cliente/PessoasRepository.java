package com.projeto.projeto_locadora.cliente;

import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PessoasRepository {

    private final ClienteRepository clienteRepository;

    public PessoasRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostConstruct
    public void carregarClientes() {
        if (clienteRepository.count() == 0) {
            List<Cliente> clientes = List.of(
                criarCliente("João da Silva", "joao.silva@email.com", "(11) 91234-5678", "123.456.789-00", "RG1234567", "Rua das Flores, 123", TipoCliente.PESSOA_FISICA, ClienteStatus.ATIVO),
                criarCliente("Maria Oliveira", "maria.oliveira@email.com", "(21) 99876-5432", "987.654.321-00", "RG7654321", "Av. Brasil, 456", TipoCliente.PESSOA_FISICA, ClienteStatus.ATIVO),
                criarCliente("Carlos Souza", "carlos.souza@email.com", "(31) 93456-7890", "111.222.333-44", "RG1122334", "Rua Minas, 789", TipoCliente.PESSOA_FISICA, ClienteStatus.INATIVO),
                criarCliente("Ana Lima", "ana.lima@email.com", "(41) 94567-8901", "555.666.777-88", "RG5566778", "Rua Paraná, 321", TipoCliente.PESSOA_FISICA, ClienteStatus.ATIVO),
                criarCliente("Luciana Costa", "luciana.costa@email.com", "(51) 95678-9012", "999.888.777-66", "RG9988776", "Av. Atlântica, 654", TipoCliente.PESSOA_FISICA, ClienteStatus.ATIVO),
                criarCliente("Bruno Almeida", "bruno.almeida@email.com", "(61) 96789-0123", "222.333.444-55", "RG2233445", "Rua Central, 222", TipoCliente.PESSOA_FISICA, ClienteStatus.BLOQUEADO),
                criarCliente("Fernanda Rocha", "fernanda.rocha@email.com", "(71) 97890-1234", "333.444.555-66", "RG3344556", "Travessa das Palmeiras, 888", TipoCliente.PESSOA_FISICA, ClienteStatus.ATIVO),
                criarCliente("Pedro Ramos", "pedro.ramos@email.com", "(81) 98901-2345", "444.555.666-77", "RG4455667", "Rua Recife, 999", TipoCliente.PESSOA_FISICA, ClienteStatus.INATIVO),
                criarCliente("Empresa XYZ", "contato@xyz.com.br", "(11) 4002-8922", "00.000.000/0001-91", "CNPJ00001", "Rua Comercial, 1000", TipoCliente.PESSOA_JURIDICA, ClienteStatus.ATIVO),
                criarCliente("Tech Solutions Ltda", "suporte@techsolutions.com", "(19) 98877-6655", "11.222.333/0001-00", "CNPJ112233", "Av. Tecnologia, 1234", TipoCliente.PESSOA_JURIDICA, ClienteStatus.BLOQUEADO)
            );

            clienteRepository.saveAll(clientes);
        }
    }

    private Cliente criarCliente(String nome, String email, String telefone, String cpf, String documento, String endereco, TipoCliente tipo, ClienteStatus status) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setDocumento(documento);
        cliente.setEndereco(endereco);
        cliente.setTipo(tipo);
        cliente.setStatus(status);
        return cliente;
    }
}
