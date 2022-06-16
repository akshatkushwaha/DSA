// Create on 2019/12/18
// Created on Turbo C++

#include <iostream.h>
#include <conio.h>
#include <fstream.h>
#include <graphics.h>
#include <stdlib.h>
#include <stdio.h>
#include <dos.h>
////////////////////////Globle Variable////////////////////////////////////////////
int n, cls;
/////////////////////////////Structure/////////////////////////////////
struct Student
{
    int R_no, pmt, cmt, mmt, omt, em, pmp, cmp, mmp, omp;      ////Marks Variable
    char nmf[20], nms[20], fnm[20], mnm[20], msb[10], osb[10]; ////Name & Subject Variable
} S;
////////////////////////////////Enter////////////////////////////////////////////
void Enter()
{
    clrscr();

    int i;
    char ch[1];
    cout << "\t\tShriKanwartara Public Higher Secondary, School";
    cout << "\n\n\tEnter Class:  ";
    cin >> ::cls;
    cout << "\n\tNo. Of Students in Class:  ";
    cin >> ::n;

    for (i = 0; i < ::n; i++)
    {
        clrscr();
        S.R_no = 00, S.pmt = 00, S.cmt = 00, S.mmt = 00, S.omt = 00, S.em = 00, S.pmp = 00, S.cmp = 00, S.mmp = 00, S.omp = 00;
        cout << "\t\tShriKanwartara Public Higher Secondary, School";
        cout << "\n\nSerial No.: " << (i + 1);
        cout << "\n\tRoll No.: ";
        cin >> S.R_no;
        cout << "\n\tName (Fisrt) : ";
        cin >> S.nmf;
        cout << "\n\tName (Second) : ";
        cin >> S.nms;
        cout << "\n\tFather's Name : ";
        cin >> S.fnm;
        cout << "\n\tMother's Name : ";
        cin >> S.mnm;
        cout << "\n\tMain Subject (M/B): ";
        cin >> ch;
        //  		if((ch=="M")||(ch=="m")){S.msb[]="Maths";}
        //	   else if((ch=="B")||(ch=="b")){S.msb[]="Bio";}
        cout << "\n\tOptional Subject : ";
        cin >> S.osb;
        clrscr();
        cout << "\t\tShriKanwartara Public Higher Secondary, School";
        cout << "\n\nEnter Marks:-";
        cout << "\n\tPhysics(Theory) : ";
    PT:
        cin >> S.pmt;
        if (S.pmt > 70)
        {
            cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
            goto PT;
        }
        cout << "\tPhysics(Practical) : ";
    PP:
        cin >> S.pmp;
        if (S.pmp > 30)
        {
            cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
            goto PP;
        }
        cout << "\tChemistry(Theory) : ";
    CT:
        cin >> S.cmt;
        if (S.cmt > 70)
        {
            cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
            goto CT;
        }
        cout << "\tChemistry(Practical) : ";
    CP:
        cin >> S.cmp;
        if (S.cmp > 30)
        {
            cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
            goto CP;
        }
        cout << "\t" << S.msb << "(Theory) : ";
    MT:
        cin >> S.mmt;
        if (S.mmt > 70)
        {
            cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
            goto MT;
        }
        if (S.msb != "Maths")
        {
            cout << "\t" << S.msb << "(Practical) : ";
        MP:
            cin >> S.mmp;
            if (S.mmp > 30)
            {
                cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
                goto MP;
            }
        }
        cout << "\tEnglish : ";
    E:
        cin >> S.em;
        if (S.pmt > 100)
        {
            cout << "Enter Correct Marks...(Marks should not be > 100):";
            goto E;
        }
        cout << "\t" << S.osb << "(Theory) : ";
    OT:
        cin >> S.omt;
        if (S.omt > 70)
        {
            cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
            goto OT;
        }
        cout << "\t" << S.osb << "(Practical) : ";
    OP:
        cin >> S.omp;
        if (S.omp > 30)
        {
            cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
            goto OP;
        }

        fstream e;
        if (::cls == 12)
        {
            e.open("File12.xlsx", ios::app);
            e << S.R_no << "\t" << S.nmf << "\t" << S.nms << "\t" << S.fnm << "\t" << S.mnm << "\t" << S.pmt << "\t" << S.cmt << "\t" << S.mmt << "\t" << S.em << "\t" << S.omt << "\t" << S.pmp << "\t" << S.cmp << "\t" << S.mmp << "\t" << S.em << "\t" << S.omp << "\n";
        }
        else if (::cls == 11)
        {
            e.open("File11.xlsx", ios::app);
            e << S.R_no << "\t" << S.nmf << "\t" << S.nms << "\t" << S.fnm << "\t" << S.mnm << "\t" << S.pmt << "\t" << S.cmt << "\t" << S.mmt << "\t" << S.em << "\t" << S.omt << "\t" << S.pmp << "\t" << S.cmp << "\t" << S.mmp << "\t"
              << "\t" << S.omp << "\n";
        }
    }
}
/////////////////////////////////Show////////////////////////////////////////////////
void Show()
{
    clrscr();
    int srn;

    cout << "\t\tShriKanwartara Public Higher Secondary, School";
    cout << "\n\n\tEnter Class:  ";
    cin >> ::cls;
    cout << "\n\tRoll No. (Search) : ";
    cin >> srn;
    fstream s;
    if (::cls == 11)
    {
        s.open("File11.xlsx", ios::in);
    }
    else if (::cls == 12)
    {
        s.open("File12.xlsx", ios::in);
    }

    while (s >> S.R_no >> S.nmf >> S.nms >> S.fnm >> S.mnm >> S.pmt >> S.cmt >> S.mmt >> S.em >> S.omt >> S.pmp >> S.cmp >> S.mmp >> S.omp >> "\n")
    {
        if (srn == S.R_no)
        {
            ////////////////Result Calculation//////////////////////////////
            int tmm = S.mmt + S.mmp;
            int tpm = S.pmt + S.pmp;
            int tcm = S.cmt + S.cmp;
            int tom = S.omt + S.omp;
            int tprm = (S.mmp + S.pmp + S.cmp + S.omp);
            int ttm = (S.em + S.mmt + S.pmt + S.cmt + S.omt);
            int oatm = tprm + ttm;
            float per = oatm / 500;
            ///////////////////////////////////////////////
            clrscr();
            int gdriver = DETECT, gmode, errorcode;
            int bkcolor, midx, midy;
            char bkname[35];

            /* initialize graphics and local variables */
            initgraph(&gdriver, &gmode, "");
            setbkcolor(9);
            //////////////////////////////////////
            cout << "\n\n\t\tShriKanwartara Public Higher Secondary, School\n";
            cout << "\n\t\t\t\t  Class " << ::cls;
            gotoxy(4, 7);
            cout << "Name of the Student:\t" << S.nmf << " " << S.nms;
            gotoxy(4, 8);
            cout << "Father's Name: " << S.fnm;
            gotoxy(50, 8);
            cout << "Mother's Name: " << S.mnm;
            gotoxy(50, 7);
            cout << "Roll No.: " << S.R_no;
            outtextxy(22, 155, "Subject");
            outtextxy(215, 144, "Marks");
            outtextxy(480, 155, "Remark");
            outtextxy(130, 166, "Theory");
            outtextxy(205, 166, "Practical");
            outtextxy(302, 166, "Total");
            outtextxy(22, 195, "English");
            outtextxy(22, 230, S.msb);
            outtextxy(22, 262, "Physics");
            outtextxy(22, 294, "Chemistry");
            outtextxy(22, 323, S.osb);
            outtextxy(22, 353, "TOTAL");
            outtextxy(22, 388, "Percent");

            rectangle(4, 135, 631, 406);
            //////////////////////Horizontal/////////////////////////////////////
            line(110, 158, 365, 158);
            line(4, 180, 631, 180);
            line(4, 214, 365, 214);
            line(4, 248, 365, 248);
            line(4, 280, 365, 280);
            line(4, 312, 365, 312);
            line(4, 340, 365, 340);
            line(4, 372, 365, 372);
            ///////////////////////////////Vertical////////////////////////////
            line(110, 135, 110, 406);
            line(365, 135, 365, 406);
            line(195, 160, 195, 372);
            line(280, 160, 280, 372);
            getch();
        }
    }
}
/////////////////////////////////Edit/////////////////////////////////////////////
void Edit()
{
    clrscr();
    int ern, r = 0;
    char ch[1];

    cout << "\t\tShriKanwartara Public Higher Secondary, School";
    cout << "\n\n\tEnter Class:  ";
    cin >> ::cls;
R:
    cout << "\tRoll No. (Edit) : ";
    cin >> ern;

    fstream s;
    if (::cls == 11)
    {
        s.open("File11.xlsx", ios::in);
    }
    else if (::cls == 12)
    {
        s.open("File12.xlsx", ios::in);
    }
    fstream u;
    if (::cls == 11)
    {
        u.open("File11u.xlsx", ios::out);
    }
    else if (::cls == 12)
    {
        u.open("File12u.xlsx", ios::out);
    }
    while (s >> S.R_no >> S.nmf >> S.nms >> S.fnm >> S.mnm >> S.pmt >> S.cmt >> S.mmt >> S.em >> S.omt >> S.pmp >> S.cmp >> S.mmp >> S.omp >> "\n")
    {
        if (ern == S.R_no)
        {
            r = 1;
            ///////////////////////Input of Update////////////////////////////
            cout << "Enter New Data:\n";
            cout << "\tName (Fisrt) : ";
            cin >> S.nmf;
            cout << "\tName (Second) : ";
            cin >> S.nms;
            cout << "\tFather's Name : ";
            cin >> S.fnm;
            cout << "\tMother's Name : ";
            cin >> S.mnm;
            cout << "\tMain Subject (M/B): ";
            cin >> ch;
            //		if((ch=="M")||(ch=="m")){S.msb[]="Maths";}
            //	   else if((ch=="B")||(ch=="b")){S.msb[]="Bio";}
            cout << "\tOptional Subject : ";
            cin >> S.osb;
            clrscr();
            cout << "\t\tShriKanwartara Public Higher Secondary, School";
            cout << "\n\nEnter Marks:-";
            cout << "\n\tPhysics(Theory) : ";
        PT:
            cin >> S.pmt;
            if (S.pmt > 70)
            {
                cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
                goto PT;
            }
            cout << "\tPhysics(Practical) : ";
        PP:
            cin >> S.pmp;
            if (S.pmp > 30)
            {
                cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
                goto PP;
            }
            cout << "\tChemistry(Theory) : ";
        CT:
            cin >> S.cmt;
            if (S.cmt > 70)
            {
                cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
                goto CT;
            }
            cout << "\tChemistry(Practical) : ";
        CP:
            cin >> S.cmp;
            if (S.cmp > 30)
            {
                cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
                goto CP;
            }
            cout << "\t" << S.msb << "(Theory) : ";
        MT:
            cin >> S.mmt;
            if (S.mmt > 70)
            {
                cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
                goto MT;
            }
            if (S.msb != "Maths")
            {
                cout << "\t" << S.msb << "(Practical) : ";
            MP:
                cin >> S.mmp;
                if (S.mmp > 30)
                {
                    cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
                    goto MP;
                }
            }
            cout << "\tEnglish : ";
        E:
            cin >> S.em;
            if (S.em > 100)
            {
                cout << "Enter Correct Marks...(Marks should not be > 100):";
                goto E;
            }
            cout << "\t" << S.osb << "(Theory) : ";
        OT:
            cin >> S.omt;
            if (S.omt > 70)
            {
                cout << "Enter Correct Marks...(Theory Marks should not be > 70):";
                goto OT;
            }
            cout << "\t" << S.osb << "(Practical) : ";
        OP:
            cin >> S.omp;
            if (S.omp > 30)
            {
                cout << "Enter Correct Marks...(Practical Marks should not be > 30):";
                goto OP;
            }
            /////////////////Input in file//////////////////////////////////
            u << S.R_no << "\t" << S.nmf << "\t" << S.nms << "\t" << S.fnm << "\t" << S.mnm << "\t" << S.pmt << "\t" << S.cmt << "\t" << S.mmt << "\t" << S.em << "\t" << S.omt << "\t" << S.pmp << "\t" << S.cmp << "\t" << S.mmp << "\t" << S.omp << "\n";
        }
        else
        {
            u << S.R_no << "\t" << S.nmf << "\t" << S.nms << "\t" << S.fnm << "\t" << S.mnm << "\t" << S.pmt << "\t" << S.cmt << "\t" << S.mmt << "\t" << S.em << "\t" << S.omt << "\t" << S.pmp << "\t" << S.cmp << "\t" << S.mmp << "\t" << S.omp << "\n";
        }
    }
    if (r == 0)
    {
        cout << "No Record Found for this Roll No....Check and Re-Enter the Roll no.:\n";
        goto R;
    }
    else if (r == 1)
    {
        cout << "\n\n\t\tData Updated Successfully";
        delay(2750);
    }
    ///////////////Delete existing File////////////////////

    ///////////////Renaming/////////////////////////
    if (::cls == 11)
    {
        rename("File11u.xls", "File11.xlsx");
    }
    else if (::cls == 12)
    {
        rename("File12u.xls", "File12.xlsx");
    }
}
/////////////////////////////////Delete////////////////////////////////////////////////
void Delete()
{
}
////////////////////////////////Main//////////////////////////////////////////
void main()
{
    system("CLS");

    int choice;
    char cnt = 'y';
    while (cnt == 'y' || 'Y')
    {
        system("CLS");
        cout << "\t\tShriKanwartara Public Higher Secondary, School\n\n\t";
        cout << "Press 1: Enter Details: \n\tPress 2: View Result: \n\tPress 3: Edit: \n\tPress 4: Delete Student Profile: \n\tPress 5: Exit:";
        gotoxy(55, 5);
    A:
        cin >> choice;

        switch (choice)
        {
        case 1:
            Enter();
            break;
        case 2:
            Show();
            break;
        case 3:
            Edit();
            break;
        case 4:
            Delete();
            break;
        case 5:
            exit(0);
            break;
        default:
            gotoxy(10, 10);
            cout << "Out of Order.... Re-Enter:  ";
            goto A;
        }
    }
    getch();
}