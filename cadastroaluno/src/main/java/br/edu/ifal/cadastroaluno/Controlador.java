package br.edu.ifal.cadastroaluno;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class Controlador{
    @Autowired
    AlunoRepositorio alunoRepo;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping("/formulario")
    public ModelAndView formulario(Aluno aluno){
        ModelAndView retorno = new ModelAndView("formulario.html");
        retorno.addObject("aluno", aluno);
        return retorno;
    }

    @RequestMapping("/aluno_cadastrado")
    public ModelAndView alunoCadastrado(Aluno aluno){
            ModelAndView resposta =  new ModelAndView("formulario.html");

            alunoRepo.save(aluno);
            
            resposta.addObject("mensagem", aluno);
            return resposta;
               
    }

    @RequestMapping("/listar_alunos")
    public ModelAndView listaAlunos(){
        ModelAndView retorno = new ModelAndView("tabela.html");
        Iterable<Aluno> alunos = alunoRepo.findAll();
        retorno.addObject("alunos", alunos);
        return retorno;
    }

    @RequestMapping("/excluir_aluno/{idAluno}")
    public ModelAndView excluirAluno(@PathVariable("idAluno") Long alunoid, RedirectAttributes redirect){
        Optional<Aluno> opcao = alunoRepo.findById(alunoid);
        ModelAndView retorno = new ModelAndView("redirect:/listar_alunos");
        if(opcao.isPresent()){
            Aluno aluno = opcao.get();
            alunoRepo.deleteById(aluno.getId());
            redirect.addFlashAttribute("mensagem", aluno.getNome() + "excluido com sucesso");
            return retorno;
        } else {
            redirect.addFlashAttribute("mensagem", "Aluno " + alunoid + "não existe no banco de dados");
            return retorno;
        }
    }

    @RequestMapping("/atualizar_aluno/{idAluno}")
    public ModelAndView atualizar(@PathVariable("idAluno") Long alunoID){
        Optional<Aluno> opcao = alunoRepo.findById(alunoID);
        ModelAndView retorno = new ModelAndView("formulario.html");
        if(opcao.isPresent()){
            Aluno aluno = opcao.get();
            retorno.addObject("aluno", aluno);
            return retorno;
        }
        return retorno;
    }
    
}