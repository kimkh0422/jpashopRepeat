package jpabookRepeat.jpashopRepeat.service;

import jpabookRepeat.jpashopRepeat.domain.Member;
import jpabookRepeat.jpashopRepeat.domain.item.Item;
import jpabookRepeat.jpashopRepeat.repository.ItemRepository;
import jpabookRepeat.jpashopRepeat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;



    //회원 가입
    @Transactional
    public Long join(Member member) {

        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicate(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    /**
     * 회원 수정
     */
    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
